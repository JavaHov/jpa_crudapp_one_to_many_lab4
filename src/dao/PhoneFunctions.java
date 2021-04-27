/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.domain.Person;
import model.domain.Phone;

/**
 *
 * @author Me
 */
public class PhoneFunctions {
    
    static PhoneDAO phoneDAO = new PhoneDAO();
    
    public static void addPhone(Phone p) {
        
        phoneDAO.addPhone(p);
    }

    
    public static void showAllPhones() {
        
        phoneDAO.showAllPhones();
    }
    
//    public static void removeAPhone(String number) {
//          
//        phoneDAO.removeAPhone(number);
//    }
    
    public static void removeAPhone(String number) {
        
        phoneDAO.removeAPhone(number);
    }

    public static Phone findPhoneByNumber(String number) {
        
        return phoneDAO.findPhoneByNumber(number);
    }

    public static void updatePhone(String oldNumber, String newNumber) {
        
        phoneDAO.updatePhone(oldNumber, newNumber);
    }

    public static void addExistingPhoneToNewPerson(Person person, String number) {
        
        phoneDAO.addExistingPhoneToNewPerson(person, number);
    }
}
