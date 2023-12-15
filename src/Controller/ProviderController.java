package Controller;

import Domain.Provider;
import Patterns.ProviderUIObserver;
import Repo.ProviderRepository;

import java.sql.SQLException;
import java.util.List;

public class ProviderController {
    private ProviderRepository providerRepository;

    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public void printAllProviders() throws SQLException {
        providerRepository.viewProviders();
    }

    public void removeProvider(int providerID) throws SQLException {
        providerRepository.removeProvider(providerID);
    }
}
