package Patterns;

import Domain.GameTable;

public class GameTableFactory {
    public static GameTable createGameTable(String title, String type, int capacity) {
        GameTable gameTable = new GameTable(title);
        gameTable.setType(type);
        gameTable.setCapacity(capacity);
        return gameTable;
    }
}

