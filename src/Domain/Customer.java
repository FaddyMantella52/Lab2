package Domain;

public class Customer implements Person {
    private int customerId;
    private int personId;
    private int loyaltyPoints;
    private double totalSpending;

    // Constructors, getters, and setters

    public Customer(int customerId, int personId, int loyaltyPoints, double totalSpending) {
        this.customerId = customerId;
        this.personId = personId;
        this.loyaltyPoints = loyaltyPoints;
        this.totalSpending = totalSpending;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getTotalSpending() {
        return totalSpending;
    }

    public void setTotalSpending(double totalSpending) {
        this.totalSpending = totalSpending;
    }

    @Override
    public String getName() {
        // Implement this method based on your requirements
        return null;
    }

    @Override
    public String getEmail() {
        // Implement this method based on your requirements
        return null;
    }

    @Override
    public int getPhoneNumber() {
        // Implement this method based on your requirements
        return 0;
    }
}
