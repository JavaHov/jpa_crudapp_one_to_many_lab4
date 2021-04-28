
package manytomanylab4;

import dao.PersonDAO;
import dao.PersonFunctions;
import dao.PhoneDAO;
import dao.PhoneFunctions;
import java.util.Scanner;
import model.domain.Person;
import model.domain.Phone;


public class MainClass {

    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {

        while (loop) {
            menu();
        }
    }

    public static void menu() {
        
        System.out.println("\n========================================");
        System.out.println("                 Menu                 ");
        System.out.println("========================================");
        System.out.println("1.Add person");
        System.out.println("2.Add phone");
        System.out.println("3.Add existing phone to new person");
        System.out.println("4.Add existing phone to existing person");
        System.out.println("5.Add new phone to existing person");
        System.out.println("6.Add new person and phone");
        System.out.println("7.Remove a phone from a person");
        System.out.println("8.Remove a person");
        System.out.println("9.Remove a phone");
        System.out.println("10.Show all persons");
        System.out.println("11.Show all phones");
        System.out.println("12.Update name of a person");
        System.out.println("13.Update phone of a person");
        System.out.println("========================================");
        System.out.print("Make your choice:");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                addPerson();
                break;
            case 2:
                addPhone();
                break;
            case 3:
                addExistingPhoneToNewPerson2(); // Konstigt här...
                break;
            case 4:
                addExistingPhoneToExistingPerson();
                break;
            case 5:
                addNewPhoneToExistingPerson();
                break;
            case 6:
                addPersonWithPhone();
                break;
            case 7:
                removeAPhoneFromPerson2();
                break;
            case 8:
                removeAPerson();
                break;
            case 9:
                removeAPhone();
                break;

            case 10:
                showAllPersons();
                break;

            case 11:
                showAllPhones();
                break;

            case 12:
                updateName();
                break;

            case 13:
                updatePhone();
                break;

            case 0:
                loop = false;
//                PhoneDAO.emf.close();
                PhoneDAO.emf.close();
                break;
            default:
                System.out.println("No such choice!");
        }

    }

    public static void removeAPerson() {
        
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        
        PersonFunctions.removePerson(id);
        
    }

    public static void addPerson() {
        
        System.out.println("Name:");
        String name = sc.nextLine();
        Person p = new Person(name);
        PersonFunctions.addPerson(p);
    }
    
    public static void addPhone() {
        
        System.out.println("Number:");
        String number = sc.nextLine();
        Phone p = new Phone(number);
        PhoneFunctions.addPhone(p);
    }

    public static void showAllPersons() {
        
        PersonFunctions.showAllPersons();
    }

    public static void showAllPhones() {
        
        PhoneFunctions.showAllPhones();
    }

    public static void removeAPhone() {
        
        System.out.println("Number:");
        String number = sc.nextLine();
        
//          System.out.println("ID of Phone:");
//          int id = sc.nextInt();
//          sc.nextLine();
//          PhoneFunctions.removeAPhone(id);
////        System.out.println("number:");
////        String number = sc.nextLine();
        PhoneFunctions.removeAPhone(number);
    }

    public static void updateName() {
        
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("New Name:");
        String newName = sc.nextLine();
        
        PersonFunctions.updateNameById(id, newName);
    }
    
    private static void updatePhone() {
            
        System.out.println("Old number:");
        String oldNumber = sc.nextLine();
        
        System.out.println("New number:");
        String newNumber = sc.nextLine();
        
        PhoneFunctions.updatePhone(oldNumber, newNumber); 
    }

    public static void addExistingPhoneToNewPerson() {
        
        System.out.println("Name:");
        String name = sc.nextLine();
        Person p = new Person(name);
        
        System.out.println("Number:");
        String number = sc.nextLine();
        
        Phone phone = PhoneFunctions.findPhoneByNumber(number);
        
        p.addPhone(phone);
        PersonFunctions.addPerson(p);
        PersonFunctions.mergePersonAndPhone(p, phone);    

    }
    public static void addExistingPhoneToNewPerson2() {
        
        System.out.println("Name:");
        String name = sc.nextLine();
        Person person = new Person(name);
        
        System.out.println("Number:");
        String number = sc.nextLine();
        
        PhoneFunctions.addExistingPhoneToNewPerson(person, number);

    }

    public static void addExistingPhoneToExistingPerson() { // Här blir det konstigt. Den tar inte bort 
                                                            // telefonen på den från första personen...
        System.out.println("Phone number:");
        String number = sc.nextLine();
        
        System.out.println("ID of Person:");
        int id = sc.nextInt();
        sc.nextLine();
        
        Phone phone = PhoneFunctions.findPhoneByNumber(number);
        
        Person person = PersonFunctions.findPersonById(id);
        

        person.addPhone(phone);
        PersonFunctions.mergePerson(person);
    }

    public static void addNewPhoneToExistingPerson() {
        
        System.out.println("Phone number:");
        String number = sc.nextLine();
        
        System.out.println("ID of person:");
        int id = sc.nextInt();
        sc.nextLine();
        
        Phone phone = new Phone(number);
        
        Person person = PersonFunctions.findPersonById(id);
        
        person.addPhone(phone);
        PersonFunctions.mergePerson(person);
    }

    public static void addPersonWithPhone() {
        
        System.out.println("Name:");
        String name = sc.nextLine();
        Person person = new Person(name);
        
        System.out.println("Number:");
        String number = sc.nextLine();
        Phone phone = new Phone(number);
        
        person.addPhone(phone);
        PersonFunctions.addPerson(person);
    }

    
    
    public static void removeAPhoneFromPerson() {
        
        System.out.println("ID of Person:");
        int id = sc.nextInt();
        sc.nextLine();
        
        Person person = PersonFunctions.findPersonById(id);
        
        System.out.println("Phonenumber to remove:");
        String number = sc.nextLine();
        
        Phone phone = PhoneFunctions.findPhoneByNumber(number);
        
        //person.removePhone(phone);
        PersonFunctions.mergePersonAndPhone(person, phone);
        
    }
    
    public static void removeAPhoneFromPerson2() {
        
        System.out.println("ID of Person:");
        int id = sc.nextInt();
        sc.nextLine();
        
        
        System.out.println("Phonenumber to remove:");
        String number = sc.nextLine();
        
        
        //person.removePhone(phone);
        PersonFunctions.removePhoneFromPerson2(id, number);
        
    }


}



