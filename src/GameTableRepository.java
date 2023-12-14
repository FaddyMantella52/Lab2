import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameTableRepository {
    private List<GameTable> gameTables = new ArrayList<>();
    private int gameTableIDCounter = 1;
    private Connection connection;

    public GameTableRepository() {
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

    public void addGameTable(GameTable gameTable) {
        String query = "INSERT INTO GameTable (Title, Type, Capacity) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, gameTable.getTitle());
            preparedStatement.setString(2, gameTable.getType());
            preparedStatement.setInt(3, gameTable.getCapacity());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    gameTable.setGameTableID(generatedID);
                    gameTables.add(gameTable);
                } else {
                    throw new SQLException("Failed to get the generated GameTable ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GameTable findGameTableByName(String gameTableName) {
        String query = "SELECT * FROM GameTable WHERE Title = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, gameTableName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int gameTableID = resultSet.getInt("GameTableID");
                    String title = resultSet.getString("Title");
                    String type = resultSet.getString("Type");
                    int capacity = resultSet.getInt("Capacity");

                    return new GameTable(gameTableID, title, type, capacity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<GameTable> getAllGameTables() {
        String query = "SELECT * FROM GameTable";
        List<GameTable> gameTables = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int gameTableID = resultSet.getInt("GameTableID");
                String title = resultSet.getString("Title");
                String type = resultSet.getString("Type");
                int capacity = resultSet.getInt("Capacity");

                gameTables.add(new GameTable(gameTableID, title, type, capacity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gameTables;
    }

    public void printAllGameTables() {
        List<GameTable> gameTables = getAllGameTables();
        for (GameTable gameTable : gameTables) {
            System.out.println(gameTable.toString());
        }
    }

    public void removeGameTable(int gameTableID) {
        String query = "DELETE FROM GameTable WHERE GameTableID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, gameTableID);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                GameTable gameTableToRemove = null;
                for (GameTable gameTable : gameTables) {
                    if (gameTable.getGameTableID() == gameTableID) {
                        gameTableToRemove = gameTable;
                        break;
                    }
                }
                if (gameTableToRemove != null) {
                    gameTables.remove(gameTableToRemove);
                }
            } else {
                System.out.println("No game table with the specified ID found for deletion.");
            }
        } catch (SQLException e) {
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