//package Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//
//import java.sql.SQLException;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import Controller.CustomerController;
//import Controller.PersonController;
//import Domain.Customer;
//import Domain.Person;
//import Repo.CustomerRepository;
//import Repo.PersonRepository;
//
//public class PersonAndCustomerRepositoryTest {
//
//    private PersonRepository personRepository;
//    private CustomerRepository customerRepository;
//    private PersonController personController;
//    private CustomerController customerController;
//
//    @Before
//    public void setUp() throws SQLException {
//        // Use an in-memory H2 database for testing
//        personRepository = new PersonRepository("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "admin", "abc123");
//        customerRepository = new CustomerRepository("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "admin", "abc123");
//        personController = new PersonController(personRepository);
//        customerController = new CustomerController(customerRepository);
//    }
//
//    @After
//    public void tearDown() throws SQLException {
//        // Close any resources or connections if needed
//        personRepository.closeConnection();
//        customerRepository.closeConnection();
//    }
//
//    @Test
//    public void testAddPerson() throws SQLException {
//        Person testPerson = new TestPerson(1, "John Doe", "john@example.com", 123456789);
//
//        personController.addPerson(testPerson);
//
//        Person retrievedPerson = personRepository.findPersonById(1);
//        assertEquals(testPerson.getName(), retrievedPerson.getName());
//        assertEquals(testPerson.getEmail(), retrievedPerson.getEmail());
//        assertEquals(testPerson.getPhoneNumber(), retrievedPerson.getPhoneNumber());
//    }
//
//    @Test
//    public void testDeletePerson() throws SQLException {
//        Person testPerson = new TestPerson(1, "John Doe", "john@example.com", 123456789);
//        personController.addPerson(testPerson);
//
//        personController.deletePerson(1);
//
//        Person retrievedPerson = personRepository.findPersonById(1);
//        assertNull(retrievedPerson);
//    }
//
//    @Test
//    public void testAddCustomer() throws SQLException {
//        Customer testCustomer = new Customer(101, 1, 100, 500.00);
//
//        customerController.addCustomer(testCustomer);
//
//        Customer retrievedCustomer = customerRepository.getCustomerById(101);
//        assertEquals(testCustomer.getLoyaltyPoints(), retrievedCustomer.getLoyaltyPoints());
//        assertEquals(testCustomer.getTotalSpending(), retrievedCustomer.getTotalSpending(), 0.01);
//    }
//
//    @Test
//    public void testDeleteCustomer() throws SQLException {
//        Customer testCustomer = new Customer(101, 1, 100, 500.00);
//        customerController.addCustomer(testCustomer);
//
//        customerController.deleteCustomer(101);
//
//        Customer retrievedCustomer = customerRepository.getCustomerById(101);
//        assertNull(retrievedCustomer);
//    }
//
//    private static class TestPerson implements Person {
//        private int personId;
//        private String name;
//        private String email;
//        private int phoneNumber;
//
//        public TestPerson(int personId, String name, String email, int phoneNumber) {
//            this.personId = personId;
//            this.name = name;
//            this.email = email;
//            this.phoneNumber = phoneNumber;
//        }
//
//        @Override
//        public int getPersonId() {
//            return personId;
//        }
//
//        @Override
//        public String getName() {
//            return name;
//        }
//
//        @Override
//        public String getEmail() {
//            return email;
//        }
//
//        @Override
//        public int getPhoneNumber() {
//            return phoneNumber;
//        }
//    }
//}
