
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
import java.util.Scanner;


public class ContactsTest {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Contacts chucky = new Contacts();
        chucky.mainMenu();



//        boolean userContinue = true;
//        do{
//            System.out.println("1. View contacts.\n" +
//                    "2. Add a new contact.\n" +
//                    "3. Search a contact by name.\n" +
//                    "4. Delete an existing contact.\n" +
//                    "5. Exit.\n" +
//                    "Enter an option (1, 2, 3, 4 or 5):");
//
//            int input = scanner.nextInt();
//
//
//
////            int userSelection = contactsMenu();
//            switch(input) {
//                case 1:
//                    chucky.showContacts();
//                    break;
//                case 2:
//                    chucky.addContact();
//                    break;
//                case 3:
//                    chucky.editContact();
//                    break;
//                case 4:
//                    chucky.deleteContact();
//                    break;
//                case 5:
//                    System.err.println("Exiting program. Have a great day!");
//                    userContinue = false;
//                    break;
//                default:
//                    System.out.println("Try selecting a different number.");
//            }
//            if(userContinue){
//                System.out.println();
//                //  userContinue = yesNo("Would you like to continue? (Y/N)");
//
//
//            }
//        }   while(userContinue);


//        //      //-----load all contats tetst
//        System.out.println("Current Address Book: ");
//        chucky.showContacts();
//        System.out.println("");
//
////      //----add contacts test
//        chucky.addContact();
//        System.out.println("Updated address book:");        chucky.showContacts();


////      // -------edit test
//        chucky.editContact();
//        System.out.println("Current Address Book after Edit: ");
//        chucky.showContacts();



//        //--------delete test
//        chucky.deleteContact();
//        System.out.println("Current Address Book after DELETE: ");
//        chucky.showContacts();
//


















    }

}


