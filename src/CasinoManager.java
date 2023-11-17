public class CasinoManager implements Person{
    private static CasinoManager instance;
    private String name;

    private CasinoManager(String name) {
        this.name = name;
    }
    public static CasinoManager getInstance(String name) {
        if (instance == null) {
            instance = new CasinoManager(name);
        }
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

}
