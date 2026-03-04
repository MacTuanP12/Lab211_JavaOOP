public class Main {
    public static void main(String[] args) {
        // Create contact manager instance
        ContactManager contactManager = new ContactManager();

        // Create view instance
        ContactView view = new ContactView(contactManager);

        // Run the application
        view.run();
    }
}