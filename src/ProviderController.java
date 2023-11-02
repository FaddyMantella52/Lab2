import java.util.List;

public class ProviderController {
    private ProviderRepository providerRepository;

    public ProviderController(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }
    public void addProvider(Provider provider){
         providerRepository.addProvider(provider);
    }
    public Provider findProviderByName(String providerName){
        return providerRepository.findProviderByName(providerName);
    }
    public List<Provider> getAllProviders(){
        return providerRepository.getAllProviders();
    }
    public void printAllAuthors() {
        providerRepository.printAllProviders();
    }
    public void removeProvider(int providerID){
        providerRepository.removeProvider(providerID);
    }
}
