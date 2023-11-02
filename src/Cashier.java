public class Cashier implements Person{
    private String name;

    public Cashier(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}
