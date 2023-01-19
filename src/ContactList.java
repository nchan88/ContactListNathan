import java.util.ArrayList;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    ArrayList <Person> contacts;
    // TODO: Write a Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact(Person e) {
        // TODO: Complete the addContact method
        contacts.add(e);
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (int i = 0; i < contacts.size(); i++)
        {
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        // TODO: Write searchByFirstName
        if (sortBy == 0)
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                for(int j = 0; j < contacts.size() - i - 1; j++)
                {
                     if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0)
                     {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);

                     }
                }
            }
            System.out.println(contacts);
        }

        if (sortBy == 1)
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                for(int j = 0; j < contacts.size() - i - 1; j++)
                {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0)
                    {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);


                    }
                }
            }
            System.out.println(contacts);
        }

        if (sortBy == 2)
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                for(int j = 0; j < contacts.size() - i - 1; j++)
                {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0)
                    {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
            System.out.println(contacts);
        }


    }

    /**
     * Lists just the Student objects in the Contact List
     */

    public Person searchByFirstName(String firstName)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getFirstName().equals(firstName))
            {
                return contacts.get(i);
            }
        }
    }
    public Person searchByLastName(String lastName)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getLastName().equals(lastName))
            {
                return contacts.get(i);
            }
        }
    }
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return contacts.get(i);
            }
        }
    }
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i)instanceof Student)
            {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
