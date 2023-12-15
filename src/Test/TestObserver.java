package Test;

import Domain.Provider;
import Domain.ProviderObserver;
import Domain.Slot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestObserver {

    @Test
    public void testProviderObserverPattern() {
        int providerId = 1;
        Provider provider = new Provider("Test Provider", providerId);

        // Create Observers
        TestProviderObserver observer1 = new TestProviderObserver();
        TestProviderObserver observer2 = new TestProviderObserver();

        // Add Observers to the Domain.Provider
        provider.addObserver(observer1);
        provider.addObserver(observer2);

        // Create and associate a Domain.Slot with the Domain.Provider
        Slot slot = new Slot(1, "Test Slot", 1, 1); // Adjust the values as needed
        provider.createSlot(slot);

        // Check if Observers were notified with the correct message
        assertEquals("New slot created by provider Test Provider", observer1.getLastMessage());
        assertEquals("New slot created by provider Test Provider", observer2.getLastMessage());
    }

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
}
