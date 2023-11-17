public class GameTable {
    private int gameTableID;
    private String title;
    private String type;
    private int capacity;

    public GameTable(String title) {
        this.title = title;
    }

    // Getters and setters for type, capacity, and gameTableID

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getGameTableID() {
        return gameTableID;
    }

    public void setGameTableID(int gameTableID) {
        this.gameTableID = gameTableID;
    }
    public String toString() {
        return "ID: " + gameTableID + ", Title: " + title + ", Type: " + type + ", Capacity: " + capacity;
    }

    // Other methods and properties specific to GameTable can be added here
}