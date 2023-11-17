import java.util.ArrayList;
import java.util.List;

interface ProviderObservable {
    void addObserver(ProviderObserver observer);
    void removeObserver(ProviderObserver observer);
    void notifyObservers(String message);
}

interface ProviderObserver {
    void update(String message);
}


public class Provider implements ProviderObservable{
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    private int ProviderID;
    private List<Slot> slots = new ArrayList<>();
    private List<ProviderObserver> observers = new ArrayList<>();

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
        notifyObservers("New slot created by provider " + name);
    }

    @Override
    public void addObserver(ProviderObserver observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(ProviderObserver observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers(String message) {
        for (ProviderObserver observer : observers) {
            observer.update(message);
        }
    }
}
