package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.UserMicroservice.model.SupMedical;
import fr.insa.UserMicroservice.model.SuperUser;

public class SupMedicalDOA {

    public SupMedicalDOA(DatabaseAccess databaseAccess) {
    }

    public static void createSupMedical(SupMedical supMedical){
        // création du SuperUser
        SuperUser superUser = new SuperUser(supMedical.getName(), supMedical.getId());
        SuperUserDOA.createSuperUser(superUser);
        String query = "INSERT INTO SupMedical (idSupMedical, Seek) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, supMedical.getId());
            preparedStatement.setString(2, supMedical.getSeek());
            preparedStatement.executeUpdate();
            System.out.println("SupMedical ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSeek(String id, String Seek){
        String query = "UPDATE SupMedical SET Seek = ? WHERE idSupMedical = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Seek);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("SupMedical Seek modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SupMedical getSupMedical(String id){
        String query = "SELECT * FROM SupMedical WHERE idSupMedical = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            SuperUser superUser = SuperUserDOA.getSuperUser(id);
            SupMedical supMedical = new SupMedical(superUser.getName(), superUser.getId(), "Empty");
            if (resultSet1.next()) {
                supMedical.setSeek(resultSet1.getString("Seek"));;
            }
            return supMedical;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<SupMedical> getAllSupMedical(){
        String query = "SELECT idSupMedical FROM SupMedical";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> allSupMedicalIDs = new ArrayList<>();
            while (resultSet.next()) {
                allSupMedicalIDs.add(resultSet.getString("idSupMedical"));
            }
            List<SupMedical> allSupMedicals = new ArrayList<>();
            for (String id : allSupMedicalIDs) {
                allSupMedicals.add(getSupMedical(id));
            }
            return allSupMedicals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
