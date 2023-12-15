package Domain;

import java.util.ArrayList;
import java.util.List;

public class Events {
    public String name;

    private List<Slot> slots = new ArrayList<>();

    public Events(String name){
        this.name = name;
    }

    public void addSlot(Slot slot){
        slots.add(slot);
    }
}
