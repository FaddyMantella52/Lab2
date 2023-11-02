import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Slot {
    private String title;

    @Override
    public String toString() {
        return "Slot{" +
                "title='" + title + '\'' +
                ", providers=" + providers +
                ", SlotId=" + SlotId +
                '}';
    }

    private List<Provider> providers = new ArrayList<>();

    private int SlotId;

    public void setSlotId(int slotId) {
        SlotId = slotId;
    }

    public int getSlotId() {
        return SlotId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addProvider(Provider provider){
        providers.add(provider);
    }
    public List<Provider> getProviders(){
        return providers;
    }

    public void printProvider(){
        for (Provider provider: providers){
            System.out.println(provider.getName());
        }
    }

    public void removeProvider(Provider provider){
        providers.remove(provider);
    }
}


