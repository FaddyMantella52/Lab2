import java.util.ArrayList;
import java.util.List;

public class ProviderRepository {
    private List<Provider> providers = new ArrayList<>();
    private int providerIDCounter = 1;

    public void addProvider(Provider provider){
        provider.setProviderID(providerIDCounter);
        providers.add(provider);
        providerIDCounter++;
    }

    public Provider findProviderByName(String providerName) {
        for (Provider provider: providers) {
            if(provider.getName().equalsIgnoreCase(providerName)){
                return provider;
            }
        }
        return null;
    }

    public List<Provider> getAllProviders(){
        return providers;
    }

    public void printAllProviders(){
        for(Provider provider:providers){
            System.out.println(provider.toString());
        }
    }

    public void removeProvider(int providerID){
        Provider providerToRemove = null;
        for(Provider provider : providers){
            if(provider.getProviderID() == providerID){
                providerToRemove = provider;
                break;
            }
        }
        if (providerToRemove != null) {
            providers.remove(providerToRemove);
        }
    }
}
