import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsTest {
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
        Contacts chucky =  new Contacts("name1","1235");
        for (String loadContact : chucky.loadContacts()) {
            System.out.println(loadContact);
        }


        List<Contacts> contacts = new ArrayList<>();
        Path contactsPath = Paths.get("/Users/Jonathan/IdeaProjects/ContactsManager/src", "contact.txt");

        List<String> contactsList = Arrays.asList("Jon doe", "Jane doe");
        try{
            Files.write(contactsPath,contactsList);
        }catch(IOException xd){
            System.out.println("It requires this useless crap");
        }
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