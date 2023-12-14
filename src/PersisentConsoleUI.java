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
            System.out.println("9. Tests");
            System.out.println("10. View Casino Manager");
            System.out.println("11. Decorate Slot");
            System.out.println("12. Quit");

            System.out.println("Enter the option number: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("What is the ID of the slot?");
                    int slot_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What is the title of the slot?");
                    String slot_title = scanner.nextLine();
                    System.out.println("What is the ID of the provider?");
                    int providerId = scanner.nextInt();
                    Slot temp_slot = new Slot(slot_id, slot_title, providerId, decoratorId);
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
                    providerRepo.addProvider(new Provider(temp_name));
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
                    gameTable.setCapacity(capacity);
                    gameTable.setGameTableID(gameTableId);
                    gameTableController.addGameTable(gameTable);
                    break;
                case 8:
                    System.out.println("The game tables are:");
                    gameTableController.printAllGameTables();
                    break;
                case 9:
                    TestSlotMethods.test_slotRepository();
                    TestProviderMethods.test_providerRepository();
                    TestGameTableMethods.testGameTableRepository();
                    TestCasinoManager.test_casinoManager();
                    TestDecorator.test_decorator();
                    TestObserver.test_provider_observer_pattern();
                    System.out.println("All Tests Completed");
                    break;  // Add break statement here
                case 10:
                    System.out.println("Casino Manager: " + casinoManager.getName());
                    break;
                case 11:
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
                case 12:
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