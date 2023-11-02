public class Provider {
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    private int ProviderID;

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", ProviderID=" + ProviderID +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getProviderID() {
        return ProviderID;
    }

    public Provider(String name){
        this.name = name;
    }

    public void setProviderID(int providerIDCounter) {
        this.ProviderID = providerIDCounter;
    }

    public void createSlot(Slot slot){
        slot.addProvider(this);
    }
}
