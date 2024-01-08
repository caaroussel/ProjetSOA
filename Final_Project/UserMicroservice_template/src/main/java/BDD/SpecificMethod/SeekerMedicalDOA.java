package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.UserMicroservice.model.HelpSeeker;
import fr.insa.UserMicroservice.model.SeekerMedical;

public class SeekerMedicalDOA {
    public SeekerMedicalDOA(DatabaseAccess databaseAccess) {
    }

    public static void createSeekerMedical(SeekerMedical seekerMedical){
        // création du demandeur
        HelpSeeker helpSeeker = new HelpSeeker(seekerMedical.getName(), seekerMedical.getMiss(), seekerMedical.getId());
        HelpSeekerDOA.createHelpSeeker(helpSeeker);
        String query = "INSERT INTO SeekerMedical (idSeekerMedical, Sup) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
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
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
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
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            HelpSeeker helpSeeker = HelpSeekerDOA.getHelpSeeker(id);
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
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
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
