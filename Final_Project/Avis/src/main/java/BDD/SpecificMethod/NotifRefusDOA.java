package BDD.SpecificMethod;
import fr.insa.Avis.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotifRefusDOA {
    public NotifRefusDOA(DatabaseAccess databaseAccess) {
    }

    public static void createNotifRefus(NotifRefus notifRefus) {
        String query = "INSERT INTO NotifRefus (idNotifRefus, idMission, idVolunteer, idHelpSeeker, idSuperUser, message) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, notifRefus.getId());
            preparedStatement.setString(2, notifRefus.getIdMission());
            preparedStatement.setString(3, notifRefus.getIdVolunteer());
            preparedStatement.setString(4, notifRefus.getIdHelpSeeker());
            preparedStatement.setString(5, notifRefus.getIdSuperUser());
            preparedStatement.setString(6, notifRefus.getMessage());
            preparedStatement.executeUpdate();
            System.out.println("NotifRefus ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static NotifRefus getNotifRefus(String id) {
        String query = "SELECT * FROM NotifRefus WHERE idNotifRefus = ?";
        NotifRefus notifRefus = null;

        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                notifRefus = new NotifRefus(rs.getString("idNotifRefus"), rs.getString("idMission"), rs.getString("idVolunteer"), rs.getString("idHelpSeeker"), rs.getString("idSuperUser"), rs.getString("message"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifRefus;
    }

    public static void updateNotifRefusMessage(String message, String id) {
        String query = "UPDATE NotifRefus SET message = ? WHERE idNotifRefus = ?";

        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, message);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("NotifRefus message modifiée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<NotifRefus> getAllNotifRefus() {
        String query = "SELECT * FROM NotifRefus";
        List<NotifRefus> notifRefusList = new ArrayList<>();

        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NotifRefus notifRefus = new NotifRefus(rs.getString("idNotifRefus"), rs.getString("idMission"), rs.getString("idVolunteer"), rs.getString("idHelpSeeker"), rs.getString("idSuperUser"), rs.getString("message"));
                notifRefusList.add(notifRefus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifRefusList;
    }

    
}
