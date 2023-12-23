package BDD.SpecificMethod;

import BDD.HelpSeeker;

import java.sql.*;

public class HelpSeekerDOA {

    private final DatabaseAccess databaseAccess;

    public HelpSeekerDOA(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void createHelpSeeker(HelpSeeker helpSeeker){
        String query = "INSERT INTO HelpSeeker (idHelpSeeker, Name, Miss) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, helpSeeker.getId());
            preparedStatement.setString(2, helpSeeker.getName());
            preparedStatement.setString(3, helpSeeker.getMiss());
            preparedStatement.executeUpdate();
            System.out.println("HelpSeeker ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HelpSeeker getHelpSeeker(String id) {
        String query = "SELECT * FROM HelpSeeker WHERE idHelpSeeker = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new HelpSeeker(resultSet.getString("Name"), resultSet.getString("Miss"), resultSet.getString("idHelpSeeker"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateHelpSeekerMission(String Miss, String id) {
        String query = "UPDATE HelpSeeker SET Miss = ? WHERE idHelpSeeker = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Miss);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("HelpSeeker Mission modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}