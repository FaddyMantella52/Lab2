package Domain;

public class Cashier implements Person {
    private String name;

    public Cashier(String name){
        this.name = name;
    }

    @Override
    public int getPersonId() {
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public int getPhoneNumber() {
        return 0;
    }
}
