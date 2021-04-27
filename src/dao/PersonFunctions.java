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
public class PersonFunctions {
    
    static PersonDAO personDAO = new PersonDAO();
    
    public static void addPerson(Person p) {
        
        personDAO.addPerson(p);
    }
    
    
    public static void removePerson(int id) {
        
        personDAO.removePerson(id);
    }
    
//    public static void removePerson(Person p) {
//        
//        personDAO.removePerson(p);
//    }
    
    public static void showAllPersons() {
        
        personDAO.showAllPersons();
    }
    
    public static Person findPersonByName(String name) {
        
        
        return personDAO.findPersonByName(name);
    }

    public static Person findPersonById(int id) {
        
        return personDAO.findPersonById(id);
        
        
    }

    public static void updateNameById(int id, String newName) {
        
        personDAO.updateNameById(id, newName);
    }

    public static void mergePersonAndPhone(Person person, Phone phone) {
        
        personDAO.mergePersonAndPhone(person, phone);
    }

    public static void mergePerson(Person p) {
        
        personDAO.mergePerson(p);
        
    }

    public static void removePhoneFromPerson2(int id, String number) {
        
        personDAO.removePhoneFromPerson2(id, number);
    }
    
}
