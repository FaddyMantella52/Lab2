package Domain;

public class ProviderGameTable {
    private int providerID;
    private int gameTableID;

    public ProviderGameTable(int providerID, int gameTableID) {
        this.providerID = providerID;
        this.gameTableID = gameTableID;
    }

    public int getProviderID() {
        return providerID;
    }

    public int getGameTableID() {
        return gameTableID;
    }
}
