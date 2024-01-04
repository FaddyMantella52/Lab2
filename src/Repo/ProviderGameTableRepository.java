package Repo;

import Domain.ProviderGameTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProviderGameTableRepository {
    private static Connection connection;

    public ProviderGameTableRepository() {
        connect();
    }

    private void connect() {
        String url = "jdbc:sqlserver://DESKTOP-D4BEKTL\\SQLEXPRESS:1433;databaseName=LaborMAP;trustServerCertificate=true";
        String user = "admin";
        String password = "abc123";

        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
    public void associateProviderWithGameTable(int providerID, int gameTableID) {
        String query = "INSERT INTO ProviderGameTable (ProviderID, GameTableID) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, providerID);
            preparedStatement.setInt(2, gameTableID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void dissociateProviderFromGameTable(int providerID, int gameTableID) {
        String query = "DELETE FROM ProviderGameTable WHERE ProviderID = ? AND GameTableID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, providerID);
            preparedStatement.setInt(2, gameTableID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
