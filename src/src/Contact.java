import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Contact {
    public String name;
    public String number;
    List<String> contactsList = new ArrayList<>();
    Path contactsPath = Paths.get("/Users/Jonathan/IdeaProjects/ContactsManager/src", "contact.txt");

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
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


    //
   public void loadContacts() {
     try {
           contactsList = Files.readAllLines(contactsPath);
       } catch (IOException stupid) {
           System.out.println("Catching This Nonsense");
       }
       for (String l : contactsList) {
           System.out.println(l);

           }
       }
    public void addContact(){
        try{
            Files.write(contactsPath,contactsList);
        }catch(IOException xd){
            System.out.println("It requires this useless crap");
        }
   }


}


//    1. Load all of the contacts by calling a method that returns a List of Contact objects.
//    2.    Call a method that shows the user the main menu and returns their choice of action.