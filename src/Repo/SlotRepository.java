package Repo;

import Domain.Slot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.management.remote.JMXConnectorFactory.connect;

public class SlotRepository {
    List<Slot> slots = new ArrayList<>();
    int slotIdCounter = 1;

    private static Connection connection;
    public SlotRepository(){
        connect();
    }

    private void connect(){
        String ur1 = "jdbc:sqlserver://DESKTOP-D4BEKTL\\SQLEXPRESS:1433;databaseName=LaborMAP;trustServerCertificate=true";
        String user = "admin";
        String password = "abc123";

        try {
            this.connection = DriverManager.getConnection(ur1,user,password);
            System.out.println("Connected to the database");
        }   catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    public void addSlot(Slot slot) throws SQLException {
        String query = "INSERT INTO Slot (Title, ProviderId, DecoratorId) OUTPUT INSERTED.SlotId VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, slot.getTitle());
            preparedStatement.setInt(2, slot.getProviderId());
            preparedStatement.setInt(3, slot.getDecoratorId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int generatedId = resultSet.getInt("SlotId");
                    slot.setSlotId(generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        slots.add(slot);
    }



    public void viewSlot() throws SQLException {
        String query = "SELECT * FROM Slot";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int slotId = resultSet.getInt("SlotId");
                String title = resultSet.getString("title");
                int providerId = resultSet.getInt("ProviderId");
                int decoratorId = resultSet.getInt("DecoratorId");

                Slot slot = new Slot(slotId, title, providerId, decoratorId);
                slots.add(slot);
                System.out.println(slot.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Slot getSlotbyId(int slotId) throws SQLException{
        String query = "SELECT * FROM Slot WHERE SlotId =? ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1,slotId);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    int SlotId = resultSet.getInt("SlotId");
                    String title = resultSet.getString("title");
                    int ProviderId = resultSet.getInt("ProviderId");
                    int DecoratorId = resultSet.getInt("DecoratorId");

                    Slot slot = new Slot(SlotId,title,ProviderId,DecoratorId);
                    return slot;
                }
            }
        }
        return null;
    }

    public Slot findSlotByTitle(String title){
        for(Slot slot: slots){
            if(slot.getTitle().equalsIgnoreCase(title)){
                return slot;
            }
        }
        return null;
    }

    public List<Slot> getAllSlots(){
        return slots;
    }

    public void printAllSlots(){
        for(Slot slot: slots){
            System.out.println(slot.toString());
        }
    }

    public void removeSlot(int slotID) throws SQLException {
        String query = "DELETE FROM Slot WHERE SlotId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,slotID);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0){
                throw new SQLException("No Domain.Slot with the specifed Id found for deletion");
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
