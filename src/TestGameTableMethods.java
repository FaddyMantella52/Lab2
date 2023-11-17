import static org.junit.Assert.*;

import java.util.List;
public class TestGameTableMethods {
    static void testGameTableMethods() {
        GameTableRepository gameTableRepo = new GameTableRepository();
        GameTableController gameTableController = new GameTableController(gameTableRepo);

        // Test adding a game table
        GameTable gameTable1 = GameTableFactory.createGameTable("Table 1", "Type A", 4);
        gameTableController.addGameTable(gameTable1);
        assertNotNull(gameTable1.getGameTableID());
        System.out.println("Add GameTable Test Completed");

        // Test finding a game table by name
        GameTable foundGameTable = gameTableController.findGameTableByName("Table 1");
        assertNotNull(foundGameTable);
        assertEquals("Table 1", foundGameTable.getTitle());
        System.out.println("Find GameTable by Name Test Completed");

        // Test getting all game tables
        List<GameTable> allGameTables = gameTableController.getAllGameTables();
        assertEquals(1, allGameTables.size());
        System.out.println("Get All GameTables Test Completed");

        // Test removing a game table
        int gameTableID = gameTable1.getGameTableID();
        gameTableController.removeGameTable(gameTableID);
        assertNull(gameTableController.findGameTableByName("Table 1"));
        System.out.println("Remove GameTable Test Completed");
    }
}
