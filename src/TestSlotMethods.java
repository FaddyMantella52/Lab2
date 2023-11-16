import static org.junit.Assert.*;

public class TestSlotMethods {
    static void test_slots(){
        SlotRepository slotRepo = new SlotRepository();
        SlotController slotController = new SlotController(slotRepo);
        Slot slot1 = new Slot();
        slot1.setTitle("Test Slot 1");
        slotController.addSlot(slot1);
        assertNotNull(slot1.getSlotId());
        System.out.println("Add Slot Test Completed");

        Slot slot2 = new Slot();
        slot2.setTitle("Test Slot 2");
        slotController.addSlot(slot2);
        Slot foundSlot = slotController.findSlotByTitle("Test Slot 2");
        assertNotNull(foundSlot);
        assertEquals("Test Slot 2", foundSlot.getTitle());
        System.out.println("Find Slot by title Test Completed");

        Slot slot3 = new Slot();
        slot3.setTitle("Test Slot 3");
        slotController.addSlot(slot3);
        int slotID= slot3.getSlotId();
        slotController.removeSlot(slotID);
        assertNull(slotController.findSlotByTitle("Test Slot 3"));
        System.out.println("Remove Book Test Completed");

        Provider provider = new Provider("test provider");
        provider.setName("Provider Name");
        Slot slot4 = new Slot();
        slot4.addProvider(provider);
        assertEquals(1,slot4.getProviders().size());
        slot4.removeProvider(provider);
        assertEquals(0,slot4.getProviders().size());
        System.out.println("Add New Provider Test Completed");
    }
}
