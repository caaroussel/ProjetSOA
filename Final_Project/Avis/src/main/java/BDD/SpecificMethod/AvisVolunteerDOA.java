package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.Avis.model.AvisVolunteer;

public class AvisVolunteerDOA {

    public AvisVolunteerDOA(DatabaseAccess databaseAccess) {
    }

    public static void createAvisVolunteer(AvisVolunteer avisVolunteer){
        String query = "INSERT INTO AvisVolunteer (idAvisVolunteer, missionId, volunteerId, comment, rating) VALUES (?,?,?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, avisVolunteer.getIdAvisVolunteer());
            preparedStatement.setString(2, avisVolunteer.getMissionId());
        	preparedStatement.setString(3, avisVolunteer.getVolunteerId());            
            preparedStatement.setString(4, avisVolunteer.getComment());
            preparedStatement.setInt(5, avisVolunteer.getRating());
            preparedStatement.executeUpdate();
            System.out.println("Volunteer ajouté avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AvisVolunteer getAvisVolunteer(String idAvisVolunteer) {
        String query = "SELECT * FROM AvisVolunteer WHERE idAvisVolunteer = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, idAvisVolunteer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AvisVolunteer(
                		resultSet.getString("idAvisVolunteer"),
                		resultSet.getString("missionId"),
                		resultSet.getString("volunteerId"),                 		 
                		resultSet.getString("comment"),
                		resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateVolunteerCommentaire(String comment, String idAvisVolunteer) {
        String query = "UPDATE AvisVolunteer SET comment = ? WHERE idAvisVolunteer = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, comment);
            preparedStatement.setString(2, idAvisVolunteer);
            preparedStatement.executeUpdate();
            System.out.println("Commentaire Volunteer modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<AvisVolunteer> getAllVolunteers() {
        String query = "SELECT * FROM AvisVolunteer";
        List<AvisVolunteer> allVolunteers = new ArrayList<>();  // Declare the list outside the try block
        
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allVolunteers.add(new AvisVolunteer(
                		resultSet.getString("idAvisVolunteer"), 
                		resultSet.getString("missionId"), 
                		resultSet.getString("volunteerId"),                 		
                		resultSet.getString("comment"),
                		resultSet.getInt("rating")));
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return allVolunteers;  
    }
}

