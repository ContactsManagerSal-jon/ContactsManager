
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    public String name;
    public String number;
    Path contactsPath = Paths.get("/Users/salvadorsalazar/IdeaProjects/JAVA PRGRAMSEXAMPLES/src/CONTACTS", "contacts.txt");

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



    //-------------add contacts
    public void addContact() throws IOException {
        System.out.println("Enter a Name and Number to ADD to Contacts");
        String name = scanner.nextLine();
//          System.out.println("enter number");
//          String number = scanner.nextLine();
        Files.write(contactsPath,Arrays.asList(name), StandardOpenOption.APPEND);

    }


    //-----------Edit/search contacts
    public void editContact() throws IOException{
        List <String> currentContacts = Files.readAllLines(contactsPath);
        List<String> newList = new ArrayList<>();
        showContacts();
        System.out.println("Enter Contact to search: ");
        String contact = scanner.nextLine();
        for(String contactInfo:currentContacts){
            if(contactInfo.contains(contact)){
                System.out.println("Update Name and Number");
                String name = scanner.nextLine();
                newList.add(name );
                System.out.println("You Have Edited : " + name+"'s Contact Info.");
                // continue;

            }else{
                newList.add(contactInfo);
            }
        }
        Files.write(contactsPath,newList);

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


}
