import java.util.ArrayList;
import java.util.List;

public class SlotRepository {
    List<Slot> slots = new ArrayList<>();
    int slotIdCounter = 1;

    public void addSlot(Slot slot){
        slot.setSlotId(slotIdCounter);
        slots.add(slot);
        slotIdCounter++;
    }

    public Slot findSlotByTitle(String title){
        for(Slot slot: slots){
            if(slot.getTitle().equalsIgnoreCase(title)){
                return slot;
            }
        }
        return null;
    }

    public List<Slot> getAllSlots(){
        return slots;
    }

    public void printAllSlots(){
        for(Slot slot: slots){
            System.out.println(slot.toString());
        }
    }

    public void removeSlot(int slotID){
        Slot slotToRemove = null;
        for(Slot slot: slots){
            if(slot.getSlotId() == slotID){
                slotToRemove = slot;
                break;
            }
        }
        if(slotToRemove != null){
            slots.remove(slotToRemove);
        }
    }
}
