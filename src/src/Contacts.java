


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
    public List<String> showContacts() {
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(contactsPath);
        } catch (IOException stupid) {
            System.out.println("Catching This Nonsense");
        }
        System.out.println("Name | Phone number\n-------------------");

        for (String l : currentList) {
            System.out.println(l);

        }

        return currentList;
    }


public  List<Contacts> readWriteContactsObjects(){
    List<String> currentList = new ArrayList<>();

    try {
        currentList = Files.readAllLines(contactsPath);
    } catch (IOException stupid) {
        System.out.println("Catching This Nonsense");
    }
    System.out.println("Name | Phone number\n-------------------");

    for (String l : currentList) {
        System.out.println(l);

    }

        for(String contact : currentList){
            List<String> each = List.of(contact.split(" "));

            contactsList.add(new Contacts(each.get(0), each.get(1) ));

        }

    return contactsList;
}




    //-------------add contacts
    public void addContact() throws IOException {
        System.out.println("Enter a Name and Number to ADD to Contacts");
        String name = scanner.nextLine();
//          System.out.println("enter number");
//          String number = scanner.nextLine();
        Files.write(contactsPath,Arrays.asList(name), StandardOpenOption.APPEND);

    }


    //-----------Edit/search contacts
    public void searchContact() throws IOException{
        List<String> currentContacts = Files.readAllLines(contactsPath);
        showContacts();
        System.out.println("Enter Contact to search: ");
        String contact = scanner.nextLine();
        for(String contactInfo:currentContacts){
            if(contactInfo.contains(contact)){
                System.out.println(contactInfo);
            }
        }
    }



    //------------delete contact
    public void deleteContact() throws IOException{
        List <String> currentContacts = Files.readAllLines(contactsPath);
        List<String> newList = new ArrayList<>();
        showContacts();
        System.out.println("Type name of contact to DELETE: ");
        String contact = scanner.nextLine();
        for(String contactInfo:currentContacts){
            if(contactInfo.contains(contact)){
//                System.out.println("Entere contact name DELETE");
//                String name = scanner.nextLine();
                newList.remove(contactInfo );
                System.out.println("you have DELETED : " + contact +" from Contacts.");
                // continue;

            }else{
                newList.add(contactInfo);
            }
        }
        Files.write(contactsPath,newList);
    }

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




//            int userSelection = contactsMenu();
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
