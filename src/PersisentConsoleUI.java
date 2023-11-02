import java.util.Scanner;

public class PersisentConsoleUI {
    public static void startConsole(){
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        SlotRepository slotRepo = new SlotRepository();
        SlotController slotController = new SlotController(slotRepo);
        ProviderRepository providerRepo = new ProviderRepository();
        ProviderController providerController = new ProviderController(providerRepo);
        //Create Providers
        Provider provider1 = new Provider("Pragmatic Play");
        Provider provider2 = new Provider("NoLimit");
        Provider provider3 = new Provider("EGT");

        Slot slot1 = new Slot();
        slot1.setTitle("Gates of Olympus");
        slot1.addProvider(provider1);

        Slot slot2 = new Slot();
        slot2.setTitle("Mental");
        slot2.addProvider(provider2);

        Slot slot3 = new Slot();
        slot3.setTitle("Shining Crown");
        slot3.addProvider(provider3);

        providerController.addProvider(provider1);
        providerController.addProvider(provider2);
        providerController.addProvider(provider3);

        slotController.addSlot(slot1);
        slotController.addSlot(slot2);
        slotController.addSlot(slot3);

        System.out.println("Welcome to the Casino");

        while(isRunning){
            //Menu options
            System.out.println("Select an Option: ");
            System.out.println("1. Add Slot ");
            System.out.println("2. Remove Slot");
            System.out.println("3. Show Slots");
            System.out.println("4. Add Provider");
            System.out.println("5. Remove Provider");
            System.out.println("6. Show Providers");
            System.out.println("7. Tests");
            System.out.println("8. Quit");

            System.out.println("Enter the option number: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    System.out.println("What is the name of the slot?");
                    String slot_name = scanner.nextLine();
                    Slot temp_slot = new Slot();
                    temp_slot.setTitle(slot_name);
                    System.out.println("Who is the provider?");
                    String temp_name2 = scanner.nextLine();
                    Provider temp_provider = new Provider(temp_name2);
                    providerRepo.addProvider(temp_provider);
                    temp_slot.addProvider(temp_provider);
                    slotController.addSlot(temp_slot);

                    break;
                case 2:
                    System.out.println("Which slot to remove?");
                    slotController.printAllSlots();
                    int slotToRemove = scanner.nextInt();
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
                    providerController.printAllAuthors();
                    int providerToRemove = scanner.nextInt();
                    providerController.removeProvider(providerToRemove);
                    System.out.println("Provider Removed");
                case 6:
                    System.out.println("The Providers are: ");
                    providerController.printAllAuthors();
                    break;
                case 7:
                    TestSlotProvider.test_slots();
                    TestSlotProvider.test_providers();
                    System.out.println("All Tests Completed");
                case 8:
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
