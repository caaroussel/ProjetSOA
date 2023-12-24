package BDD.SpecificMethod;
import BDD.Mission;
import java.sql.*;

public class MissionDOA {
    private final DatabaseAccess databaseAccess;

    public MissionDOA(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void createMission(Mission mission) {
        String query = "INSERT INTO Mission (idMission, Seeker, Vol, Goal, Status, Opinion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, mission.getId());
            preparedStatement.setString(2, mission.getSeek());
            preparedStatement.setString(3, mission.getVol());
            preparedStatement.setString(4, mission.getGoal());
            preparedStatement.setString(5, mission.getStatus().toString());
            preparedStatement.setString(6, mission.getOpinion());
            preparedStatement.executeUpdate();
            System.out.println("Mission ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMissionSeeker(String Seeker, String id) {
        String query = "UPDATE Mission SET Seeker = ? WHERE idMission = ?";

        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Seeker);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Mission Seeker modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMissionVol(String Vol, String id) {
        String query = "UPDATE Mission SET Vol = ? WHERE idMission = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Vol);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Mission Volunteer modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMissionStatus(Mission.Status Status, String id) {
        String query = "UPDATE Mission SET Status = ? WHERE idMission = ?";

        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Status.toString());
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Mission Status modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMissionOpinion(String Opinion, String id) {
        String query = "UPDATE Mission SET Opinion = ? WHERE idMission = ?";

        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, Opinion);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Mission Opinion modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Mission getMission(String id) {
        String query = "SELECT * FROM Mission WHERE idMission = ?";
        try (PreparedStatement preparedStatement = databaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Mission(resultSet.getString("Vol"), resultSet.getString("Seeker"), Mission.Status.valueOf(resultSet.getString("Status")), resultSet.getString("Opinion"), resultSet.getString("Goal"), resultSet.getString("idMission"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
