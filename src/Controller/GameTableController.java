package Controller;

import Domain.GameTable;
import Repo.GameTableRepository;

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
        gameTableRepository.printAllGameTables();
    }

    public void removeGameTable(int gameTableID) {
        gameTableRepository.removeGameTable(gameTableID);
    }

    public void closeConnection() {
    }
}
