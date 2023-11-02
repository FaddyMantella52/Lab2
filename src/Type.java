import java.util.ArrayList;
import java.util.List;

public class Type {
    private String name;
    private List<Slot> slots = new ArrayList<>();

    public Type(String name){
        this.name = name;
    }

    public void addSlot(Slot slot){
        slots.add(slot);
    }
}
