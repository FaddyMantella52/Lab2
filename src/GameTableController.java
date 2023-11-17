import java.util.List;
public class GameTableController {
    private GameTableRepository gameTableRepository;

    public GameTableController(GameTableRepository gameTableRepository) {
        this.gameTableRepository = gameTableRepository;
    }

    public void addGameTable(GameTable gameTable) {
        gameTableRepository.addGameTable(gameTable);
    }

    public GameTable findGameTableByName(String gameTableName) {
        return gameTableRepository.findGameTableByName(gameTableName);
    }

    public List<GameTable> getAllGameTables() {
        return gameTableRepository.getAllGameTables();
    }

    public void printAllGameTables() {
        List<GameTable> gameTables = gameTableRepository.getAllGameTables();
        for (GameTable gameTable : gameTables) {
            System.out.println(gameTable.toString()); // Update to use the standard toString method
        }
    }

    public void removeGameTable(int gameTableID) {
        gameTableRepository.removeGameTable(gameTableID);
    }
}
