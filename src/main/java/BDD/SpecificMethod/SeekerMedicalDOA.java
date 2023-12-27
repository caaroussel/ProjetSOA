package BDD.SpecificMethod;

import BDD.HelpSeeker;
import BDD.SeekerMedical;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeekerMedicalDOA {
    private final DatabaseAccess databaseAccess;

    public SeekerMedicalDOA(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void createSeekerMedical(SeekerMedical seekerMedical){
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

    public void updateSeekerMedicalSup(String Sup, String id) {
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

    public SeekerMedical getSeekerMedical(String id){
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

    public List<String> getAllSeekMedicalIDs (){
        String query = "SELECT idSeekerMedical FROM SeekerMedical";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> allSeekerMedicalIDs = new ArrayList<>();
            while (resultSet.next()) {
                allSeekerMedicalIDs.add(resultSet.getString("idSeekerMedical"));
            }
            return allSeekerMedicalIDs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
