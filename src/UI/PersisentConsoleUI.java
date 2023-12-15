package UI;

import Controller.*;
import Domain.*;
import Patterns.*;
import Repo.*;

import java.sql.SQLException;
import java.util.Scanner;

public class PersisentConsoleUI {
    public static void startConsole() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int decoratorId = 1;

        SlotRepository slotRepo = new SlotRepository();
        SlotController slotController = new SlotController(slotRepo);

        ProviderRepository providerRepo = new ProviderRepository();
        ProviderController providerController = new ProviderController(providerRepo);

        GameTableRepository gameTableRepo = new GameTableRepository();
        GameTableController gameTableController = new GameTableController(gameTableRepo);

        CustomerRepository customerRepository = new CustomerRepository();
        CustomerController customerController = new CustomerController(customerRepository);

        ProviderGameTableRepository providerGameTableRepository = new ProviderGameTableRepository();
        ProviderGameTableController providerGameTableController = new ProviderGameTableController(providerGameTableRepository);

        CasinoManager casinoManager = CasinoManager.getInstance("John Doe");
        System.out.println("Welcome to the Casino");

        while (isRunning) {
            // Menu options
            System.out.println("Select an Option: ");
            System.out.println("1. Add Slot ");
            System.out.println("2. Remove Slot");
            System.out.println("3. Show Slots");
            System.out.println("4. Add Provider");
            System.out.println("5. Remove Provider");
            System.out.println("6. Show Providers");
            System.out.println("7. Add GameTable");
            System.out.println("8. Show GameTables");
            System.out.println("9. Remove GameTable");
            System.out.println("10. View Casino Manager");
            System.out.println("11. Add Client");
            System.out.println("12. Remove Client");
            System.out.println("13. Show all Clients");
            System.out.println("14. Decorate Slot");
            System.out.println("15. Associate or Dessociate Provider and GameTable");
            System.out.println("16. Quit");

            System.out.println("Enter the option number: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("What is the title of the slot?");
                    String slot_title = scanner.nextLine();
                    System.out.println("What is the ID of the provider?");
                    System.out.println("The Providers are: ");
                    providerController.printAllProviders();
                    int providerId = scanner.nextInt();
                    Slot temp_slot = new Slot(0, slot_title, providerId, decoratorId); // Set SlotId to 0 or any default value
                    slotController.addSlot(temp_slot);
                    System.out.println("Slot added");
                    break;

                case 2:
                    System.out.println("Which slot to remove?");
                    slotController.printAllSlots();
                    int slotToRemove = scanner.nextInt();
                    slotController.removeSlot(slotToRemove);
                    System.out.println("Slot Removed");
                    break;
                case 3:
                    System.out.println("The slots are:");
                    slotController.printAllSlots();
                    break;
                case 4:
                    System.out.println("What is the name of the provider?");
                    String temp_name = scanner.nextLine();
                    System.out.println("What is the ID of the provider?");
                    int temp_int = scanner.nextInt();
                    providerRepo.addProvider(new Provider(temp_name,temp_int));
                    System.out.println("Provider added");
                    break;
                case 5:
                    System.out.println("Which Provider-ID to remove?");
                    providerController.printAllProviders();
                    int providerToRemove = scanner.nextInt();
                    providerController.removeProvider(providerToRemove);
                    System.out.println("Provider Removed");
                    break;  // Add break statement here
                case 6:
                    System.out.println("The Providers are: ");
                    providerController.printAllProviders();
                    break;
                case 7:
                    System.out.println("What is the name of the game table?");
                    String title = scanner.nextLine();
                    System.out.println("What is the ID of the game table?");
                    int gameTableId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the type of the game table:");
                    String type = scanner.nextLine();
                    System.out.println("Enter the capacity of the game table:");
                    int capacity = scanner.nextInt();
                    GameTable gameTable = new GameTable(title);
                    gameTable.setType(type);
                    gameTable.setGameTableID(gameTableId);
                    gameTable.setCapacity(capacity);
                    gameTableController.addGameTable(gameTable);
                    break;
                case 8:
                    System.out.println("The game tables are:");
                    gameTableController.printAllGameTables();
                    break;
                case 9:
                    System.out.println("Which ID-GameTable to remove?");
                    gameTableController.printAllGameTables();
                    int gameTableToRemove = scanner.nextInt();
                    gameTableController.removeGameTable(gameTableToRemove);
                    System.out.println("GameTable removed.");
                    break;
                case 10:
                    System.out.println("Casino Manager: " + casinoManager.getName());
                    break;

                case 11:
                    System.out.println("What is the ID of the customer ?");
                    int customer_id = scanner.nextInt();
                    System.out.println("What is the ID of the person ?");
                    int person_id = scanner.nextInt();
                    System.out.println("How many loyality Points ?");
                    int points = scanner.nextInt();
                    System.out.println("How much money spent ?");
                    int money = scanner.nextInt();
                    customerRepository.addCustomer(new Customer(customer_id,person_id,points,money));
                    System.out.println("Customer added");
                    break;
                case 12:
                    System.out.println("Which Customer-ID to remove ?");
                    customerController.viewCustomers();
                    int customerToRemove = scanner.nextInt();
                    customerController.deleteCustomer(customerToRemove);
                    System.out.println("Customer Removed");
                    break;
                case 13:
                    System.out.println("The Customers are:");
                    customerController.viewCustomers();
                    break;
                case 14:
                    System.out.println("Dynamic Slot Decoration:");
                    System.out.println("Enter the name of the slot you want to decorate:");
                    String slotToDecorateName = scanner.nextLine();
                    Slot slotToDecorate = slotController.findSlotByTitle(slotToDecorateName);

                    if (slotToDecorate != null) {
                        System.out.println("1. Add Bonus Feature");
                        System.out.println("2. Add Theme");
                        int decorationOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (decorationOption) {
                            case 1:
                                slotToDecorate.addDecorator(new BonusFeatureDecorator());
                                System.out.println("Bonus Feature added to the slot!");
                                break;
                            case 2:
                                slotToDecorate.addDecorator(new ThemeDecorator());
                                System.out.println("Theme added to the slot!");
                                break;
                            default:
                                System.out.println("Invalid decoration option.");
                        }
                    } else {
                        System.out.println("Slot not found. Decoration failed.");
                    }
                    break;  // Add break statement here
                case 15:
                    System.out.println("Enter ID from provider");
                    providerController.printAllProviders();
                    int temp_int1 = scanner.nextInt();
                    System.out.println("Enter ID from gametable");
                    gameTableController.printAllGameTables();
                    int temp_int2 = scanner.nextInt();
                    System.out.println("Enter 1 for association and 2 for dissociation");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){
                        case 1:
                            providerGameTableController.associateProviderWithGameTable(temp_int1,temp_int2);
                            System.out.println("Association complete");
                            break;
                        case 2:
                            providerGameTableController.dissociateProviderFromGameTable(temp_int1,temp_int2);
                            System.out.println("Dissociation complete");
                    }
                    break;
                case 16:
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Option. Please select a valid option.");
            }
        }
        scanner.close();
    }
}