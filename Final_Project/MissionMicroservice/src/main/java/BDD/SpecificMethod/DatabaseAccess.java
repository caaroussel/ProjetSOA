package BDD.SpecificMethod;

import java.sql.*;

public class DatabaseAccess {

    public static Connection getConnection() throws SQLException {
        String connectionURL = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_052?serverTimezone=UTC";
        return DriverManager.getConnection(connectionURL, "projet_gei_052", "Xanguex0");
    }


    // Méthode pour exécuter une requête SELECT
    public static ResultSet executeQuery(String query) throws SQLException {
        System.out.println("Executing query: " + query);
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        return stmt.executeQuery(query);
    }

    // Méthode pour exécuter une requête INSERT, UPDATE ou DELETE
    public static int executeUpdate(String query) {
        System.out.println("Executing query: " + query);
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Méthode pour fermer la connexion à la base de données
    public static void closeConnection() {
        try {
            getConnection().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

