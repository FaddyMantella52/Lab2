package Controller;

import Domain.Customer;
import Repo.CustomerRepository;

import java.sql.SQLException;

public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        try {
            customerRepository.addCustomer(customer);
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
        }
    }

    public void deleteCustomer(int customerId) {
        try {
            customerRepository.removeCustomer(customerId);
        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
        }
    }

    public void viewCustomers() throws SQLException {
        customerRepository.viewCustomers();
    }

    public void closeConnection() {
        customerRepository.closeConnection();
    }
}

