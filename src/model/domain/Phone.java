package model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Me
 */
@Entity
public class Phone {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String number;

    public Phone() {
        
    }
    
    public Phone(String number) {
        
        this.number = number;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", number=" + number + '}';
    }
    
    

}