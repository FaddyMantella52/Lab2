package Repo;

import Domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private static Connection connection;

    public PersonRepository() {
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

    public Person findPersonById(int personId) throws SQLException {
        String query = "SELECT * FROM Person WHERE PersonId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, personId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    String email = resultSet.getString("Email");
                    int phoneNumber = resultSet.getInt("PhoneNumber");

                    return new Person() {
                        @Override
                        public int getPersonId() {
                            return personId;
                        }

                        @Override
                        public String getName() {
                            return name;
                        }

                        @Override
                        public String getEmail() {
                            return email;
                        }

                        @Override
                        public int getPhoneNumber() {
                            return phoneNumber;
                        }
                    };
                }
            }
        }
        return null;
    }
    public void addPerson(Person person) throws SQLException {
        String query = "INSERT INTO Person (PersonId, Name, Email, PhoneNumber) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,person.getPersonId());
            preparedStatement.setString(2,person.getName());
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.setInt(4,person.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(int personId) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,personId);
            int affectedRows = preparedStatement.executeUpdate();

            if(affectedRows == 0) {
                throw new SQLException("No person with the specified Id found for deletion.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
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