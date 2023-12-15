package Test;

import java.sql.SQLException;
import java.util.List;

import Controller.GameTableController;
import Domain.GameTable;
import Repo.GameTableRepository;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameTableMethods {
    @Test
    public void testGameTableRepository() throws SQLException {
        GameTableRepository gameTableRepo = new GameTableRepository();
        GameTableController gameTableController = new GameTableController(gameTableRepo);

        // Print the initial state of the GameTable table
        System.out.println("Initial GameTable state: " + gameTableController.getAllGameTables());

        // Test adding a Domain.GameTable
        GameTable gameTable1 = new GameTable("Table1");
        gameTableController.addGameTable(gameTable1);

        // Print the state after adding a Domain.GameTable
        System.out.println("State after adding a GameTable: " + gameTableController.getAllGameTables());

        // Test finding a Domain.GameTable by name
        GameTable foundGameTable = gameTableController.findGameTableByName("Table1");
        assertNotNull(foundGameTable);
        assertEquals("Table1", foundGameTable.getTitle());

        // Test removing a Domain.GameTable
        int gameTableIdToRemove = foundGameTable.getGameTableID();
        gameTableController.removeGameTable(gameTableIdToRemove);

        // Print the state after removing a Domain.GameTable
        System.out.println("State after removing a GameTable: " + gameTableController.getAllGameTables());

        // Test getting all GameTables
        List<GameTable> allGameTables = gameTableController.getAllGameTables();
        System.out.println("All Game Tables: " + allGameTables);

        // Assert the count of GameTables
        int expectedGameTableCount = 1;
        assertEquals(expectedGameTableCount, allGameTables.size());

        System.out.println("Repo.GameTableRepository Tests Completed");
    }
}
