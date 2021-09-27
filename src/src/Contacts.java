


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Contacts {
    public String name;
    public String number;
    Path contactsPath = Paths.get("src", "contact.txt");
    public List<Contacts> contactsList = new ArrayList<Contacts>();
    Scanner scanner = new Scanner(System.in);

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contacts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //--------------Show all contacts
    public void showContacts() {
        System.out.println("Name | Phone number\n-------------------");
        for (Contacts contacts : contactsList) {
            System.out.println(contacts.name + " | "+ contacts.number);
        }
    }


public  List<Contacts> readTextToContactsList(){
    List<String> currentList = new ArrayList<>();
    try {
        currentList = Files.readAllLines(contactsPath);
    } catch (IOException stupid) {
        System.out.println("Catching This Nonsense");
    }
        for(String contact : currentList){
            List<String> each = List.of(contact.split("/"));
            contactsList.add(new Contacts(each.get(0), each.get(1)));
        }
    return contactsList;
}


    //-------------add contacts
    public void addContact() throws IOException {
        System.out.println("Enter a Name of the contact");
        String name = scanner.nextLine();
        System.out.println("Please enter the number to reach them at");
        String number = scanner.nextLine();
        for(Contacts contact: contactsList){
            if(contact.name.equals(name)){
                System.out.println("That contact already exists would you like to enter a diferent one?");
                String yayNay = scanner.nextLine();
                if(yayNay.contains("y")){
                    addContact();
                    return;
                }
                return;
            }
        }
        contactsList.add(new Contacts(name,number));

    }


    //-----------search contacts
    public void searchContact() throws IOException{
        System.out.println("Enter Contact to search: ");
        String contact = scanner.nextLine();
        for(Contacts contactInfo: contactsList){
            if(contactInfo.name.equals(contact)){
                System.out.println(contactInfo.name + " | " + contactInfo.number);
            }
        }
    }


    //------------delete contact
    public void deleteContact() throws IOException {
        System.out.println("Type name of contact to DELETE: ");
        String contact = scanner.nextLine();
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).name.equals(contact)) {
                contactsList.remove(i);
                System.out.println("you have DELETED : " + contact + " from Contacts.");
            }
        }
    }


//------- Main menu layout
public void mainMenu() throws IOException {
    boolean userContinue = true;
    do{
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        int input = scanner.nextInt();
        String ghostString = scanner.nextLine();

        switch(input) {
            case 1:
                this.showContacts();
                break;
            case 2:
                this.addContact();
                break;
            case 3:
                this.searchContact();
                break;
            case 4:
                this.deleteContact();
                break;
            case 5:
                System.err.println("Exiting program. Have a great day!");
                List<String> exitList = new ArrayList<>();
                for(Contacts newList : contactsList){
                    exitList.add(newList.name + "/" + newList.number);
                }
                Files.write(contactsPath,exitList);
                userContinue = false;
                break;
            default:
                System.out.println("Try selecting a different number.");
        }
        if(userContinue){
            System.out.println();
            //  userContinue = yesNo("Would you like to continue? (Y/N)");


        }
    }   while(userContinue);
}
}
