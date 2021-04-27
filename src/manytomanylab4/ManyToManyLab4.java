
package manytomanylab4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.domain.Person;
import model.domain.Phone;

/**
 *
 * @author Me
 */
public class ManyToManyLab4 {

    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        
        EntityManager em = emf.createEntityManager();
        
        Person p = em.find(Person.class, 1);
        
        System.out.println(p);
        
//        Phone phone2 = new Phone("555555");
//        p.addPhone(phone2);
        
//        em.getTransaction().begin();
//        
//        em.merge(p);
//        
//        em.getTransaction().commit();
      
    }
    
}
