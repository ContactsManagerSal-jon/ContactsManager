import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactTest {
    public void createContact(){

    }

//------------addcontact method Work in Progress
//    public static void addContacts(Path contacts,String name,String number){
//        List<String> contactsList = Arrays.asList(name);
//        try{
//            Files.write(contacts,contactsList, StandardOpenOption.APPEND.())
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//    }



    //public static List<Contacts> loadContacts(List<Contact>)

    public static void main(String[] args) {
        Contact chucky =  new Contact("name1","1235");
        chucky.loadContacts();

        List<Contact> contacts = new ArrayList<>();

        Path contactsPath = Paths.get("/Users/Jonathan/IdeaProjects/ContactsManager/src", "contact.txt");

        List<String> contactsList = Arrays.asList("Jon doe", "Jane doe");

//
//        List<String> currentList = new ArrayList<>();
//        try{
//            currentList = Files.readAllLines(contactsPath);
//        }catch(IOException stupid){
//            System.out.println("Catching This Nonsense");
//        }
//        for(String l : currentList){
//            System.out.println(l);
        }




    }

//}
