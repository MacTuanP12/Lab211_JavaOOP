import java.util.Scanner;


public class ContactView {
    private ContactManager contactManager;
    private Scanner scanner;


    public ContactView(ContactManager contactManager) {
        this.contactManager = contactManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Contact program");
        System.out.println("=".repeat(50));
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.print("Please choice one option: ");
    }


    public int getUserChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    public void handleAddContact() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Add a Contact");
        System.out.println("-".repeat(50));

        // Get contact information
        System.out.print("Enter Name: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Enter Group: ");
        String group = scanner.nextLine().trim();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();

        // Get phone number with validation
        String phone = getValidPhoneNumber();

        if (phone == null) {
            System.out.println("Failed to add contact due to invalid phone number.");
            return;
        }

        // Add contact
        boolean success = contactManager.addContact(fullName, group, address, phone);

        if (success) {
            System.out.println("Successful");
        } else {
            System.out.println("Failed to add contact. Please check your input.");
        }
    }


    private String getValidPhoneNumber() {
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine().trim();

        while (!ContactValidator.isValidPhone(phone)) {
            System.out.println("Invalid phone format. Please input phone flow:");
            System.out.println("• 1234567890");
            System.out.println("• 123-456-7890");
            System.out.println("• 123-456-7890 x1234");
            System.out.println("• 123-456-7890 ext1234");
            System.out.println("• (123)-456-7890");
            System.out.println("• 123.456.7890");
            System.out.println("• 123 456 7890");
            System.out.print("Enter Phone: ");
            phone = scanner.nextLine().trim();

            // Validate the phone
            if (ContactValidator.isValidPhone(phone)) {
                break;
            }
        }

        return phone;
    }


    public void handleDisplayAll() {
        contactManager.displayAll();
    }


    public void handleDeleteContact() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Delete a Contact");
        System.out.println("-".repeat(50));

        boolean deleted = false;

        while (!deleted) {
            System.out.print("Enter ID: ");
            String idInput = scanner.nextLine().trim();

            try {
                int id = Integer.parseInt(idInput);

                // Check if contact exists
                if (!contactManager.contactExists(id)) {
                    System.out.println("No found contact");
                    continue; // Ask for ID again
                }

                // Delete contact
                boolean success = contactManager.deleteContactById(id);

                if (success) {
                    System.out.println("Successful");
                    deleted = true; // Exit loop and return to menu
                } else {
                    System.out.println("Failed to delete contact.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ID is not valid. Please enter a number.");
            }
        }
    }


    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    handleAddContact();
                    break;
                case 2:
                    handleDisplayAll();
                    break;
                case 3:
                    handleDeleteContact();
                    break;
                case 4:
                    System.out.println("\nExiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
                    break;
            }
        }

        scanner.close();
    }
}

