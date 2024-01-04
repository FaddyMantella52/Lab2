package Repo;

import Domain.Customer;
import Domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static Connection connection;

    public CustomerRepository() {
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

    public void addCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO Customer (CustomerId, PersonId, LoyaltyPoints, TotalSpending) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setInt(2, customer.getPersonId());
            preparedStatement.setInt(3, customer.getLoyaltyPoints());
            preparedStatement.setDouble(4, customer.getTotalSpending());
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle primary key violation (duplicate CustomerId)
            System.err.println("Error: CustomerId must be unique and not null.");
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            // Handle other SQL exceptions
            e.printStackTrace();
        }
    }

    public void removeCustomer(int customerId) throws SQLException {
        String query = "DELETE FROM Customer WHERE CustomerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No Customer with the specified ID found for deletion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewCustomers() throws SQLException {
        String query = "SELECT * FROM Customer";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int customerId = resultSet.getInt("CustomerId");
                int personId = resultSet.getInt("PersonId");
                int loyaltyPoints = resultSet.getInt("LoyaltyPoints");
                double totalSpending = resultSet.getDouble("TotalSpending");

                Customer customer = new Customer(customerId, personId, loyaltyPoints, totalSpending);

                System.out.println("Customer ID: " + customer.getCustomerId() + ", Person ID: " + customer.getPersonId() +
                        ", Loyalty Points: " + customer.getLoyaltyPoints() + ", Total Spending: " + customer.getTotalSpending());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(int customerId) throws SQLException {
        String query = "SELECT * FROM Customer WHERE CustomerId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int personId = resultSet.getInt("PersonId");
                    int loyaltyPoints = resultSet.getInt("LoyaltyPoints");
                    double totalSpending = resultSet.getDouble("TotalSpending");

                    Customer customer = new Customer(customerId, personId, loyaltyPoints, totalSpending);
                    return customer;
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
