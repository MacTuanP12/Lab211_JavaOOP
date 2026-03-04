import java.util.ArrayList;
import java.util.List;


public class ContactManager {
    private List<Contact> contactList;
    private int nextId;


    public ContactManager() {
        this.contactList = new ArrayList<>();
        this.nextId = 1;
    }


    public boolean addContact(List<Contact> list, Contact contact) {
        if (contact == null) {
            return false;
        }

        // Validate phone number
        if (!ContactValidator.isValidPhone(contact.getPhone())) {
            return false;
        }

        // Validate required fields
        if (!ContactValidator.isNotEmpty(contact.getFullName()) ||
            !ContactValidator.isNotEmpty(contact.getGroup()) ||
            !ContactValidator.isNotEmpty(contact.getAddress())) {
            return false;
        }

        list.add(contact);
        return true;
    }


    public boolean addContact(String fullName, String group, String address, String phone) {
        Contact contact = new Contact(nextId, fullName, group, address, phone);
        boolean result = addContact(contactList, contact);
        if (result) {
            nextId++;
        }
        return result;
    }


    public void displayAll(List<Contact> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n" + "=".repeat(115));
        System.out.println("Display all Contact");
        System.out.println("=".repeat(115));
        System.out.printf("%-5s %-20s %-15s %-15s %-10s %-15s %-15s%n",
                "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");

        for (Contact contact : list) {
            System.out.println(contact);
        }
        System.out.println("=".repeat(115));
    }


    public void displayAll() {
        displayAll(contactList);
    }


    public boolean deleteContact(List<Contact> list, Contact contact) {
        if (list == null || contact == null) {
            return false;
        }
        return list.remove(contact);
    }


    public boolean deleteContactById(int id) {
        Contact contact = findContactById(id);
        if (contact == null) {
            return false;
        }
        return deleteContact(contactList, contact);
    }


    public Contact findContactById(int id) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }


    public boolean contactExists(int id) {
        return findContactById(id) != null;
    }


    public List<Contact> getContactList() {
        return contactList;
    }


    public int getNextId() {
        return nextId;
    }
}

