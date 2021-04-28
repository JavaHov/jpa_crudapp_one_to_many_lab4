/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.domain.Person;
import model.domain.Phone;




public class PhoneDAO {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    
    public void addPhone(Phone p) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();  
    }

    
    public void showAllPhones() {
        
        EntityManager em = emf.createEntityManager();

        TypedQuery<Phone> query = em.createQuery("SELECT p FROM Phone p", Phone.class);
        //emf.getCache().evict(Phone.class); // Funkar som raden nedan.
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
        List<Phone> resultList = query.getResultList();
        resultList.forEach(p -> System.out.println(p));
        em.close();
    }
    
    public void removeAPhone(String number) {
        
        EntityManager em = emf.createEntityManager();
        TypedQuery<Phone> query = em.createQuery("SELECT p FROM Phone p WHERE p.number=:number", Phone.class);
        query.setParameter("number", number);
        Phone p = query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
    // --------------------------------------------------------------------------
    public void removeAPhone(int id) {
        
        EntityManager em = emf.createEntityManager();
        Phone phone = em.find(Phone.class, id);
        
        em.getTransaction().begin();
        em.remove(phone);
        em.getTransaction().commit();
        em.close();
        
    }
    //---------------------------------------------------------------------------

    public Phone findPhoneByNumber(String number) {
        
        EntityManager em = emf.createEntityManager();
        TypedQuery<Phone> query = em.createQuery("SELECT p FROM Phone p WHERE p.number=:number", Phone.class);
        query.setParameter("number", number);
        Phone p = query.getSingleResult();
        em.close();
        return p;
    }

    void updatePhone(String oldNumber, String newNumber) {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Phone> query = em.createQuery("SELECT p FROM Phone p WHERE p.number=:oldNumber", Phone.class);
        query.setParameter("oldNumber", oldNumber);
        Phone phone = query.getSingleResult();
        
        em.getTransaction().begin();
        phone.setNumber(newNumber);    // Vet inte om det är rätt att sätta den här mellan begin och commit...
        em.getTransaction().commit();
        em.close();
    }

    void addExistingPhoneToNewPerson(Person person, String number) {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Phone> query = em.createQuery("SELECT p FROM Phone p WHERE p.number=:number", Phone.class);
        query.setParameter("number", number);
        Phone phone = query.getSingleResult();
        
        
        // Det här funkar också nu...
        person.addPhone(phone);
        
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        
        
        
        // Funkar...
//        em.getTransaction().begin();
//        person.addPhone(em.merge(phone));
//        em.persist(em.merge(person));
//        em.getTransaction().commit();
//        em.close();
    }
    
}
