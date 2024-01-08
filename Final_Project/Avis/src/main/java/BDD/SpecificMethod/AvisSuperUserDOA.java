package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.Avis.model.AvisSuperUser;

public class AvisSuperUserDOA {

    public AvisSuperUserDOA(DatabaseAccess databaseAccess) {
    }

    public static void createAvisSuperUser(AvisSuperUser AvisSuperUser){
        String query = "INSERT INTO AvisSuperUser (idAvisSuperUser, missionId, SupId, comment, rating) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
        	preparedStatement.setString(1, AvisSuperUser.getIdAvisSuperUser());
            preparedStatement.setString(2, AvisSuperUser.getMissionId());
            preparedStatement.setString(3, AvisSuperUser.getUtilisateur());
            preparedStatement.setString(4, AvisSuperUser.getCommentaire());
            preparedStatement.setInt(5, AvisSuperUser.getNote());
            preparedStatement.executeUpdate();
            System.out.println("AvisSuperUser ajouté avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AvisSuperUser getAvisSuperUser(String idAvisSuperUser) {
        String query = "SELECT * FROM AvisSuperUser WHERE idAvisSuperUser = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, idAvisSuperUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AvisSuperUser(
                    	resultSet.getString("idAvisSuperUser"), 
                        resultSet.getString("missionId"),
                        resultSet.getString("SupId"),
                        resultSet.getString("comment"),
                        resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateSuperUserCommentaire(String comment, String idAvisSuperUser) {
        String query = "UPDATE AvisSuperUser SET comment = ? WHERE idAvisSuperUser = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, comment);
            preparedStatement.setString(2, idAvisSuperUser);
            preparedStatement.executeUpdate();
            System.out.println("Commentaire AvisSuperUser modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<AvisSuperUser> getAllSuperUsers() {
        String query = "SELECT * FROM AvisSuperUser";
        List<AvisSuperUser> allSuperUsers = new ArrayList<>();  
        
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allSuperUsers.add(new AvisSuperUser(
                	resultSet.getString("idAvisSuperUser"), 
                    resultSet.getString("SupId"), 
                    resultSet.getString("missionId"), 
                    resultSet.getString("comment"),
                    resultSet.getInt("rating")
                ));
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return allSuperUsers;  
    }


         
       
         
}

