package BDD.SpecificMethod;

import BDD.Mission;
import BDD.Volunteer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolunteerDOA {

    private final DatabaseAccess databaseAccess;

    public VolunteerDOA(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void createVolunteer(Volunteer volunteer)
    {
        String query = "INSERT INTO Volunteer (idVolunteer, Name, Miss) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, volunteer.getId());
            preparedStatement.setString(2, volunteer.getName());
            preparedStatement.setString(3, volunteer.getMiss());
            preparedStatement.executeUpdate();
            System.out.println("Volunteer ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Volunteer getVolunteer(String id) {
        String query = "SELECT * FROM Volunteer WHERE idVolunteer = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Volunteer(resultSet.getString("Name"), resultSet.getString("Miss"), resultSet.getString("idVolunteer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVolunteerMission(String Miss, String id) {
        String query = "UPDATE Volunteer SET Miss = ? WHERE idVolunteer = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Miss);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Volunteer Mission modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Volunteer> getAllVolunteers() {
        String query = "SELECT * FROM Volunteer";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Volunteer> allVolunteer = new ArrayList<>();
            while (resultSet.next()) {
                allVolunteer.add(new Volunteer(resultSet.getString("Name"), resultSet.getString("Miss"), resultSet.getString("idVolunteer")));
            }
            return allVolunteer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
