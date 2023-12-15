package Patterns;

import Domain.ProviderObserver;

public class ProviderUIObserver implements ProviderObserver {
    @Override
    public void update(String message){
        System.out.println("UI updated: " + message);
    }
}
