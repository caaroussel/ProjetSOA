package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.UserMicroservice.model.SuperUser;
public class SuperUserDOA {

    public SuperUserDOA(DatabaseAccess databaseAccess) {
    }

    public static void createSuperUser(SuperUser superUser){
        String query = "INSERT INTO SuperUser (idSuperUser, Name) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, superUser.getId());
            preparedStatement.setString(2, superUser.getName());
            preparedStatement.executeUpdate();
            System.out.println("SuperUser ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SuperUser getSuperUser(String id) {
        String query = "SELECT * FROM SuperUser WHERE idSuperUser = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new SuperUser(resultSet.getString("Name"), resultSet.getString("idSuperUser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<SuperUser> getAllSuperUsers() {
        String query = "SELECT * FROM SuperUser";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<SuperUser> allSuperUsers = new ArrayList<>();
            while (resultSet.next()) {
                allSuperUsers.add(new SuperUser(resultSet.getString("Name"), resultSet.getString("idSuperUser")));
            }
            return allSuperUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
