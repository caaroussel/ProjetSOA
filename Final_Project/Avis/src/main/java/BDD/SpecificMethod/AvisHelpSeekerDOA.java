package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.Avis.model.AvisHelpSeeker;

public class AvisHelpSeekerDOA {

    public AvisHelpSeekerDOA(DatabaseAccess databaseAccess) {
    }

    public static void createAvisHelpSeeker(AvisHelpSeeker avisHelpSeeker){
        String query = "INSERT INTO AvisHelpSeeker (idAvisHelpSeeker, missionId, helpSeekerId, comment, rating) VALUES (?,?,?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, avisHelpSeeker.getIdAvisHelpSeeker());
            preparedStatement.setString(2, avisHelpSeeker.getMissionId());
        	preparedStatement.setString(3, avisHelpSeeker.getHelpSeekerId());
            preparedStatement.setString(4, avisHelpSeeker.getComment());
            preparedStatement.setInt(5, avisHelpSeeker.getRating());
            preparedStatement.executeUpdate();
            System.out.println("AvisHelpSeeker ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AvisHelpSeeker getAvisHelpSeeker(String idAvisHelpSeeker) {
        String query = "SELECT * FROM AvisHelpSeeker WHERE idAvisHelpSeeker = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, idAvisHelpSeeker);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AvisHelpSeeker(
                		resultSet.getString("idAvisHelpSeeker"),
                		resultSet.getString("missionId"),
                        resultSet.getString("helpSeekerId"),
                        resultSet.getString("comment"),
                        resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateAvisHelpSeekerRating(int rating, String idAvisHelpSeeker) {
        String query = "UPDATE AvisHelpSeeker SET rating = ? WHERE idAvisHelpSeeker = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, rating);
            preparedStatement.setString(2, idAvisHelpSeeker);
            preparedStatement.executeUpdate();
            System.out.println("AvisHelpSeeker Rating modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<AvisHelpSeeker> getAllAvisHelpSeekers() {
        String query = "SELECT * FROM AvisHelpSeeker";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AvisHelpSeeker> allAvisHelpSeekers = new ArrayList<>();
            while (resultSet.next()) {
                allAvisHelpSeekers.add(new AvisHelpSeeker(
                				resultSet.getString("idAvisHelpSeeker"),
                        		resultSet.getString("missionId"),
                                resultSet.getString("helpSeekerId"),
                                resultSet.getString("comment"),
                                resultSet.getInt("rating")));
            }
            return allAvisHelpSeekers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
