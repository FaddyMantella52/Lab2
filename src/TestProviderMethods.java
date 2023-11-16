import static org.junit.Assert.*;

public class TestProviderMethods {
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
