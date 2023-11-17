import static org.junit.Assert.*;

public class TestObserver {
    static class TestProviderObserver implements ProviderObserver {
        private String lastMessage;

        @Override
        public void update(String message) {
            this.lastMessage = message;
        }

        public String getLastMessage() {
            return lastMessage;
        }
    }
    static void test_provider_observer_pattern() {
        Provider provider = new Provider("Test Provider");

        // Create Observers
        TestProviderObserver observer1 = new TestProviderObserver();
        TestProviderObserver observer2 = new TestProviderObserver();

        // Add Observers to the Provider
        provider.addObserver(observer1);
        provider.addObserver(observer2);

        // Create and associate a Slot with the Provider
        Slot slot = new Slot();
        slot.setTitle("Test Slot");
        provider.createSlot(slot);

        // Check if Observers were notified with the correct message
        assertEquals("New slot created by provider Test Provider", observer1.getLastMessage());
        assertEquals("New slot created by provider Test Provider", observer2.getLastMessage());
    }
}
