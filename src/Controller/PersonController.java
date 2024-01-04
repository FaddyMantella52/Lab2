package Controller;

import Domain.Person;
import Repo.PersonRepository;

import java.sql.SQLException;

public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person) {
        try {
            personRepository.addPerson(person);
            System.out.println("Person added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding person to the database.");
            e.printStackTrace();
        }
    }

    public void deletePerson(int personId) {
        try {
            personRepository.deletePerson(personId);
            System.out.println("Person deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting person from the database.");
            e.printStackTrace();
        }
    }
}
