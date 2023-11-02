public class Customer implements Person{
    private String name;

    public Customer(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}
