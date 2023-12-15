package Test;

import static org.junit.Assert.assertEquals;

import Domain.CasinoManager;
import org.junit.Test;

public class TestCasinoManager {

    @Test
    public void testCasinoManager() {
        // Test Casino Manager
        CasinoManager casinoManager = CasinoManager.getInstance("John Doe");
        assertEquals("John Doe", casinoManager.getName());
    }
}