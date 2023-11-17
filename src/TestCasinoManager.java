import static org.junit.Assert.*;

public class TestCasinoManager {
    static void test_casinoManager(){
        // Test Casino Manager
        CasinoManager casinoManager = CasinoManager.getInstance("John Doe");
        assertEquals("John Doe", casinoManager.getName());
        System.out.println("Casino Manager Test Completed");}
}
