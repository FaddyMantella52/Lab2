package Test;


import Domain.Slot;
import Repo.SlotRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TestSlotMethods {

    private static SlotRepository slotRepository;

    @BeforeClass
    public static void setUp() {
        slotRepository = new SlotRepository();
    }

    @AfterClass
    public static void tearDown() {
        // Close the connection after all tests are executed
        slotRepository.closeConnection();
    }

    @Test
    public void testAddSlot() throws SQLException {
        Slot slot = new Slot(0, "Test Slot", 345, 1);
        slotRepository.addSlot(slot);

        assertNotNull(slot.getSlotId());
        System.out.println("Add Slot Test Completed");
    }

    @Test
    public void testViewSlot() throws SQLException {
        System.out.println("Viewing Slots:");
        slotRepository.viewSlot();
        System.out.println("View Slot Test Completed");
    }

    @Test
    public void testGetSlotById() throws SQLException {
        Slot slot = new Slot(0, "Test Slot", 345, 1);
        slotRepository.addSlot(slot);

        Slot retrievedSlot = slotRepository.getSlotbyId(slot.getSlotId());
        assertNotNull(retrievedSlot);
        assertEquals("Test Slot", retrievedSlot.getTitle());
        System.out.println("Get Slot by Id Test Completed");
    }

    @Test
    public void testFindSlotByTitle() {
        Slot slot = slotRepository.findSlotByTitle("Test Slot");
        assertNotNull(slot);
        assertEquals("Test Slot", slot.getTitle());
        System.out.println("Find Slot by Title Test Completed");
    }

    @Test
    public void testGetAllSlots() {
        List<Slot> allSlots = slotRepository.getAllSlots();
        assertFalse(allSlots.isEmpty());
        System.out.println("Get All Slots Test Completed");
    }

    @Test
    public void testRemoveSlot() throws SQLException {
        Slot slot = new Slot(0, "Test Slot", 345, 1);
        slotRepository.addSlot(slot);

        int slotID = slot.getSlotId();
        slotRepository.removeSlot(slotID);

        assertNull(slotRepository.findSlotByTitle("Test Slot"));
        System.out.println("Remove Slot Test Completed");
    }
}
