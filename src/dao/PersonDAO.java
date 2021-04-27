/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.PhoneDAO.emf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.domain.Person;
import model.domain.Phone;

/**
 *
 * @author Me
 */
public class PersonDAO {
    
    
    //public static EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("PU");
    
    public void addPerson(Person p) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(em.merge(p)); 
        em.getTransaction().commit();
        em.close();
    }
    
//    public void removePerson(Person p) {
//        
//        EntityManager em = emf2.createEntityManager();
//        
//        em.getTransaction().begin();
//        em.remove(em.merge(p)); // Här behövs merge så att den här lokala em vet vilket objekt som avses.
//        em.getTransaction().commit();
//        em.close(); 
//    }
    
    public void removePerson(int id) {
        
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id); 
        
        em.getTransaction().begin();
        em.remove(p); // Här behövs ingen merge för man använder den här em till att hitta objektet i tabellen.
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void showAllPersons() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
    
    public Person findPersonByName(String name) {
        
        
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.name=:name", Person.class);
        query.setParameter("name", name);
        
        Person person = query.getSingleResult();
        return person;
    }
    
    public Person findPersonById(int id) {
        
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        return person;
    }

    void updateNameById(int id, String newName) {
        
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        
        em.getTransaction().begin();
        p.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    void removePhoneFromPerson(Person person, Phone phone) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(person).removePhone(em.merge(phone));
        em.getTransaction().commit();
        em.close();
    }

    void mergePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();        
        
    }

    void removePhoneFromPerson2(int id, String number) {
        
         EntityManager em = emf.createEntityManager();
         
         Person person = em.find(Person.class, id);
         
        TypedQuery<Phone> createQuery = em.createQuery("SELECT p FROM Phone p WHERE p.number=:number", Phone.class);
        Phone phone = createQuery.setParameter("number", number).getSingleResult();
        
         
         em.getTransaction().begin();
         person.removePhone(phone);
         em.getTransaction().commit();
         em.close();
    }

    void mergePersonAndPhone(Person person, Phone phone) {
        
        
    }
    

}
