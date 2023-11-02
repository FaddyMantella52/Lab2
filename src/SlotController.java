import java.util.List;

public class SlotController {
    private SlotRepository slotRepository;

    public SlotController(SlotRepository slotRepository){
        this.slotRepository = slotRepository;
    }

    public void addSlot(Slot slot){
        slot.setSlotId(slotRepository.slotIdCounter);
        slotRepository.slots.add(slot);
        slotRepository.slotIdCounter++;
    }

    public void printAllSlots(){
        slotRepository.printAllSlots();
    }

    public Slot findSlotByTitle(String title){
        return slotRepository.findSlotByTitle(title);
    }

    public List<Slot> getAllSlots(){
        return slotRepository.getAllSlots();
    }

    public void removeSlot(int slotID){
        slotRepository.removeSlot(slotID);
    }
}
