package BDD.SpecificMethod;

import BDD.SupMedical;
import BDD.SuperUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupMedicalDOA {

    private final DatabaseAccess databaseAccess;

    public SupMedicalDOA(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void createSupMedical(SupMedical supMedical){
        // création du SuperUser
        SuperUser superUser = new SuperUser(supMedical.getName(), supMedical.getId());
        SuperUserDOA superUserDOA = new SuperUserDOA(databaseAccess);
        superUserDOA.createSuperUser(superUser);
        String query = "INSERT INTO SupMedical (idSupMedical, Seek) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, supMedical.getId());
            preparedStatement.setString(2, supMedical.getSeek());
            preparedStatement.executeUpdate();
            System.out.println("SupMedical ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSeek(String id, String Seek){
        String query = "UPDATE SupMedical SET Seek = ? WHERE idSupMedical = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Seek);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("SupMedical Seek modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SupMedical getSupMedical(String id){
        String query = "SELECT * FROM SupMedical WHERE idSupMedical = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            SuperUserDOA superUserDOA = new SuperUserDOA(databaseAccess);
            SuperUser superUser = superUserDOA.getSuperUser(id);
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

    public List<String> getAllSupMedicalIDs(){
        String query = "SELECT idSupMedical FROM SupMedical";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> allSupMedicalIDs = new ArrayList<>();
            while (resultSet.next()) {
                allSupMedicalIDs.add(resultSet.getString("idSupMedical"));
            }
            return allSupMedicalIDs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
