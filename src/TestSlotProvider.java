import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSlotProvider {
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

    static void test_providers(){
        Provider provider1 = new Provider("Test Provider 1");
        assertEquals("Test Provider 1", provider1.getName());
        System.out.println("Add Provider Test Completed");

        Slot slot = new Slot();
        provider1.createSlot(slot);
        assertEquals(1,slot.getProviders().size());
        assertEquals(provider1,slot.getProviders().get(0));
        System.out.println("Create slot test Completed");

        provider1.setProviderID(500);
        assertEquals(500,provider1.getProviderID());
        ProviderRepository providerRepo = new ProviderRepository();
        ProviderController providerController = new ProviderController(providerRepo);
        Provider provider2 = new Provider("Test Provider 2");
        providerController.addProvider(provider2);
        assertEquals(1,providerController.getAllProviders().size());
        System.out.println("Provider Repo test Completed");

        Provider provider3 = new Provider("Test Provider 3");
        providerController.addProvider(provider3);
        Provider foundProvider = providerController.findProviderByName("Test Provider 3");
        assertNotNull(foundProvider);
        assertEquals("Test Provider 3",foundProvider.getName());
        System.out.println("Find Provider By Name Test Completed");

        Provider provider4 = new Provider("Test Provider 4");
        providerController.addProvider(provider4);
        int providerID = provider4.getProviderID();
        providerController.removeProvider(providerID);
        assertNull(providerController.findProviderByName("Test Provider 4"));
        System.out.println("Remove Test Completed");
    }
}
