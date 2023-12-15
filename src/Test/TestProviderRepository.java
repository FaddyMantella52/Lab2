package Test;

import Domain.Provider;
import Repo.ProviderRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class TestProviderRepository {

    private ProviderRepository providerRepository;
    private int testProviderId; // Variable to store the ID of the test provider

    @Before
    public void setUp() throws SQLException {
        providerRepository = new ProviderRepository();

        // Add a test provider to the database during setup
        Provider testProvider = new Provider("Test Provider", 1);
        providerRepository.addProvider(testProvider);

        // Store the ID of the test provider for cleanup
        testProviderId = testProvider.getProviderID();
    }

    @After
    public void tearDown() throws SQLException {
        // Remove the test provider from the database during teardown
        providerRepository.removeProvider(testProviderId);
        providerRepository.closeConnection();
    }

    @Test
    public void testAddProviderAndGetProviderById() throws SQLException {
        // Test addProvider method
        Provider provider = new Provider("Test Provider", 2);
        providerRepository.addProvider(provider);

        // Test getProviderById method
        Provider retrievedProvider = providerRepository.getProviderById(provider.getProviderID());

        assertNotNull(retrievedProvider);
        assertEquals(provider.getName(), retrievedProvider.getName());
        assertEquals(provider.getProviderID(), retrievedProvider.getProviderID());
    }

    @Test
    public void testRemoveProvider() throws SQLException {
        // Test removeProvider method
        providerRepository.removeProvider(testProviderId);

        // Verify that the provider is removed
        assertNull(providerRepository.getProviderById(testProviderId));
    }

    @Test
    public void testViewProviders() throws SQLException {
        // Test viewProviders method
        providerRepository.viewProviders();
        // Assuming that the viewProviders method doesn't throw exceptions and is successful
    }
}
