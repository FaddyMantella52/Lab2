package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Domain.GameTable;
import Domain.Provider;
import Repo.ProviderGameTableRepository;
import Domain.ProviderGameTable;

public class ProviderGameTableController {
    private ProviderGameTableRepository repository;

    public ProviderGameTableController(ProviderGameTableRepository repository) {
        this.repository = repository;
    }

    public void associateProviderWithGameTable(int providerID, int gameTableID) {
        repository.associateProviderWithGameTable(providerID, gameTableID);
    }

    public void dissociateProviderFromGameTable(int providerID, int gameTableID) {
        repository.dissociateProviderFromGameTable(providerID, gameTableID);
    }

    public List<GameTable> getGameTablesByProvider(int providerID) {
        // Implement logic to retrieve associated GameTables for a given Provider
        // You can execute a SQL query or use existing methods in GameTableRepository
        return null;
    }

    public List<Provider> getProvidersByGameTable(int gameTableID) {
        // Implement logic to retrieve associated Providers for a given GameTable
        // You can execute a SQL query or use existing methods in ProviderRepository
        return null;
    }
}