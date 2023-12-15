package Domain;

public class CasinoManager implements Person {
    private static CasinoManager instance;
    private String name;

    private int personID;

    private String email;
    private int phoneNumber;

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
    public int getPersonId() {
        return 0;
    }

    @Override
    public String getName() {
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
