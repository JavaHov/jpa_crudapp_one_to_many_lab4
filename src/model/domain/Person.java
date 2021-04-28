package model.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Me
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    
    //@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER )
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER) // Det här kanske löste ett problem.
    @JoinColumn(name = "person_id")
    private List<Phone> phones;

    
    public Person() {
        
    }
    
    public Person(String name) {
        
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        if (phones == null) {
            phones = new ArrayList<>();
        }
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone phone) {
        getPhones().add(phone);
    }

    public void removePhone(Phone phone) {
        getPhones().remove(phone);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", phones=" + phones + '}';
    }
    
    

}