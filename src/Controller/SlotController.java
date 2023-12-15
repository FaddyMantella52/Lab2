package Controller;

import Domain.Slot;
import Repo.SlotRepository;

import java.util.List;
import java.sql.SQLException;

public class SlotController {
    private SlotRepository slotRepository;

    public SlotController(SlotRepository slotRepository){
        this.slotRepository = slotRepository;
    }

    public void addSlot(Slot slot) throws SQLException {
        slotRepository.addSlot(slot);
    }

    public void printAllSlots() throws SQLException {
        slotRepository.viewSlot();
    }

    public Slot findSlotByTitle(String title){
        return slotRepository.findSlotByTitle(title);
    }

    public List<Slot> getAllSlots(){
        return slotRepository.getAllSlots();
    }

    public void removeSlot(int slotID) throws SQLException{
        slotRepository.removeSlot(slotID);
    }
}
