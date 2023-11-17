import java.util.ArrayList;
import java.util.List;

public class GameTableRepository {
    private List<GameTable> gameTables = new ArrayList<>();
    private int gameTableIDCounter = 1;

    public void addGameTable(GameTable gameTable) {
        gameTable.setGameTableID(gameTableIDCounter);
        gameTables.add(gameTable);
        gameTableIDCounter++;
    }

    public GameTable findGameTableByName(String gameTableName) {
        for (GameTable gameTable : gameTables) {
            if (gameTable.getTitle().equalsIgnoreCase(gameTableName)) {
                return gameTable;
            }
        }
        return null;
    }

    public List<GameTable> getAllGameTables() {
        return gameTables;
    }

    public void printAllGameTables() {
        for (GameTable gameTable : gameTables) {
            System.out.println(gameTable.toString());
        }
    }

    public void removeGameTable(int gameTableID) {
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
    }
}
