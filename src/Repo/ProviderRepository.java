package Repo;

import Domain.Provider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderRepository {
    private static Connection connection;
  //  private List<Provider> providers = new ArrayList<>();
   // private int providerIDCounter = 1;

    public ProviderRepository() {
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

    public void addProvider(Provider provider) throws SQLException {
        String query = "INSERT INTO Provider (ProviderId, Name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, provider.getProviderID());
            preparedStatement.setString(2, provider.getName());
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle primary key violation (duplicate ProviderId)
            System.err.println("Error: ProviderId must be unique and not null.");
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            // Handle other SQL exceptions
            e.printStackTrace();
        }
    }

    public void removeProvider(int providerID) throws SQLException{
        String query = "DELETE FROM Provider WHERE ProviderID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, providerID);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No Provider with the specified ID found for deletion.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProviders() throws SQLException{
        String query = "SELECT * FROM Provider";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()) {
                int ProviderID = resultSet.getInt("ProviderId");
                String name = resultSet.getString("Name");

                Provider provider = new Provider(name,ProviderID);

                System.out.println("Provider ID: " + provider.getProviderID() + ", Name: " + provider.getName());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Provider getProviderById(int ProviderId) throws SQLException {
        String query = "SELECT * FROM Provider WHERE ProviderId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ProviderId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("ProviderId");
                    String name = resultSet.getString("Name");

                    Provider provider = new Provider(name, ProviderId);
                    return provider;
                }
            }
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}