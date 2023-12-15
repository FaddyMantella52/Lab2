package Domain;

import Domain.Provider;
import Patterns.SlotDecorator;


import java.util.ArrayList;
import java.util.List;

public class Slot {
    private String title;
    private int providerId;
    private int decoratorId;
    private int slotId;
    private List<Provider> providers = new ArrayList<>();
    private List<SlotDecorator> decorators = new ArrayList<>();

    public Slot(int slotId,String title,int providerId,int decoratorId){
        this.slotId = slotId;
        this.title = title;
        this.providerId = providerId;
        this.decoratorId = decoratorId;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "title='" + title + '\'' +
                ", SlotId=" + slotId +
                ",ProviderId=" + providerId +
                ",DecoratorId=" + decoratorId +
                '}';
    }
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addProvider(Provider provider){
        providers.add(provider);
    }

    public int getProviderId(){
        return providerId;
    }

    public void setProviderID(int providerId){
        this.providerId = providerId;
    }
    public List<Provider> getProviders(){
        return providers;
    }

    public void printProvider(){
        for (Provider provider: providers){
            System.out.println(provider.getName());
        }
    }

    public void removeProvider(Provider provider){
        providers.remove(provider);
    }

    public void addDecorator(SlotDecorator decorator) {
        decorators.add(decorator);
    }

    public int getDecoratorId(){
        return decoratorId;
    }

    public void setDecoratorId(int decoratorId){
        this.decoratorId = decoratorId;
    }

    public void decorate() {
        for (SlotDecorator decorator : decorators) {
            decorator.decorateSlot(this);
        }
    }
}


