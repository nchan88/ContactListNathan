import java.util.ArrayList;
import java.util.Scanner;

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
    Scanner reader;
    // TODO: Write a Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
        reader = new Scanner(System.in);
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
            //number of passes through the arraylist
            for(int i = 0; i < contacts.size(); i++)
            {
                for(int j = 0; j < contacts.size() - i - 1; j++)
                {
                    //uses bubble sort by using the compareTo method, sees if it has higher ASCII value and if it does it is switched
                     if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0)
                     {
                         //swaps the person objects with each other
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);

                     }
                }
            }
            System.out.println(contacts);
        }
        //same thing but with last name being compared
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
        //same thing but with phone number being compared
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
            //returns first match in the array, not sorted in any particular order. Same goes for lastName and phoneNumber
            if (contacts.get(i).getFirstName().equals(firstName))
            {
                return contacts.get(i);
            }
        }
        return null;
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
        return null;
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
        return null;
    }
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (int i = 0; i < contacts.size(); i++)
        {
            //instance of is used here to see if contacts at i is a student so that we can print it
            if (contacts.get(i)instanceof Student)
            {
                //prints the toString of the student object.
                System.out.println(contacts.get(i));
            }
        }
    }

//    public void listSuperheros() {
//        for (int i = 0; i < contacts.size(); i++)
//        {
//            //psuedocode if the code allowed for a method to list superheroes, only the object name "Superhero is changed"
//            if (contacts.get(i)instanceof Superhero)
//            {
//                //prints the toString of the student object.
//                System.out.println(contacts.get(i));
//            }
//        }
//    }

    public void createNewContact()
            //I created this function because run was already getting pretty long I felt like the logic of adding
            //a new contact was complex enough to warrant it's own function
    {
        System.out.println("What type of person is this?");
        System.out.println("\n1. A Student");
        System.out.println("2. A Superhero");
        int selection = reader.nextInt();
        reader.nextLine();
        if (selection == 1)
        {
            System.out.println("What is their first name?");
            String firstName = reader.nextLine();
            System.out.println("What is their last name?");
            String lastName = reader.nextLine();
            System.out.println("What is their phone number?");
            String phoneNumber = reader.nextLine();
            System.out.println("What is their grade?");
            int grade = reader.nextInt();
            reader.nextLine();
            //creates new object to put into the contacts ArrayList
            addContact(new Student(firstName, lastName, phoneNumber, grade));
            System.out.println("Contact has been succesfully created for " + firstName + " " + lastName);
        }
        else if (selection == 2)
        {
            System.out.println("What is their first name?");
            String firstName = reader.nextLine();
            System.out.println("What is their last name?");
            String lastName = reader.nextLine();
            System.out.println("What is their phone number?");
            String phoneNumber = reader.nextLine();
            System.out.println("What is their superpower?");
            String power = reader.nextLine();
            //creates new object to put into the contacts ArrayList
            addContact(new Superhero(firstName, lastName, phoneNumber, power));
            System.out.println("Contact has been succesfully created for " + firstName + " " + lastName);
        }
        else if (selection != 1 && selection != 2)
        {
            //error message
            System.out.println("Invalid index provided, returning to menu.");
        }
    }
    public void run() {
        // TODO: Complete the run method
        int input = -1;
        //while loop stops when 0 is pressed and the program ends
        while (input != 0)
        {
            System.out.println("Welcome to your Contacts List");
            System.out.println("Please pick from the following menu options");
            printMenuOptions();
            System.out.print("Enter index: ");
            input = reader.nextInt();
            reader.nextLine();
            if (input == 1)
            {
                createNewContact();
                input = -1;
            }
            else if (input == 2)
            {
                sort(0);
                input = -1;
            }
            else if (input == 3)
            {
                sort(1);
                input = -1;
            }
            else if (input == 4)
            {
                sort(2);
                input = -1;
            }
            else if (input == 5)
            {
                listStudents();
                input = -1;
            }
            else if (input == 6)
            {
                System.out.println("Enter a first name: ");
                String firstName = reader.nextLine();
                //searchByFirstName returns an object or null, if null it is not present
                if (searchByFirstName(firstName) == null)
                {
                    System.out.println(firstName + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByFirstName(firstName));
                }
                input = -1;
            }
            else if (input == 7)
            {
                System.out.println("Enter a last name: ");
                String lastName = reader.nextLine();
                if (searchByLastName(lastName) == null)
                {
                    System.out.println(lastName + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByLastName(lastName));
                }
                input = -1;
            }
            else if (input == 8)
            {
                System.out.println("Enter a phone number: ");
                String phoneNumber = reader.nextLine();
                if (searchByPhoneNumber(phoneNumber) == null)
                {
                    System.out.println(phoneNumber + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }
                input = -1;
            }
            else if (input == 9)
            {
                //ends the while loop and contactlist.java is terminated
                input = 0;
            }
        }
        }



    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
