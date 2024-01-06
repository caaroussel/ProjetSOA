package BDD.SpecificMethod;

import BDD.HelpSeeker;
import BDD.SeekerMedical;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeekerMedicalDOA {
    private static DatabaseAccess databaseAccess;

    public SeekerMedicalDOA(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public static void createSeekerMedical(SeekerMedical seekerMedical){
        // création du demandeur
        HelpSeeker helpSeeker = new HelpSeeker(seekerMedical.getName(), seekerMedical.getMiss(), seekerMedical.getId());
        HelpSeekerDOA helpSeekerDOA = new HelpSeekerDOA(databaseAccess);
        helpSeekerDOA.createHelpSeeker(helpSeeker);
        String query = "INSERT INTO SeekerMedical (idSeekerMedical, Sup) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, seekerMedical.getId());
            preparedStatement.setString(2, seekerMedical.getSuperUser());
            preparedStatement.executeUpdate();
            System.out.println("SeekerMedical ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSeekerMedicalSup(String Sup, String id) {
        String query = "UPDATE SeekerMedical SET Sup = ? WHERE idSeekerMedical = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Sup);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("SeekerMedical Sup modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SeekerMedical getSeekerMedical(String id){
        String query = "SELECT * FROM SeekerMedical WHERE idSeekerMedical = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            HelpSeekerDOA helpSeekerDOA = new HelpSeekerDOA(databaseAccess);
            HelpSeeker helpSeeker = helpSeekerDOA.getHelpSeeker(id);
            SeekerMedical seekerMedical = new SeekerMedical(helpSeeker.getName(), helpSeeker.getMiss(), helpSeeker.getId(), "Empty");
            if (resultSet1.next()) {
                seekerMedical.setSuperUser(resultSet1.getString("Sup"));;
            }
            return seekerMedical;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<SeekerMedical> getAllSeekMedical (){
        String query = "SELECT idSeekerMedical FROM SeekerMedical";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> allSeekerMedicalIDs = new ArrayList<>();
            while (resultSet.next()) {
                allSeekerMedicalIDs.add(resultSet.getString("idSeekerMedical"));
            }
            List<SeekerMedical> allSeekerMedicals = new ArrayList<>();
            for (String id : allSeekerMedicalIDs) {
                allSeekerMedicals.add(getSeekerMedical(id));
            }
            return allSeekerMedicals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
