/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
<<<<<<< HEAD
=======

>>>>>>> 9d87868fbefe3083b557a62470d8feff6f02f7c9
/**
 *
 * @author user
 */
<<<<<<< HEAD
public class Reader implements Serializable {
=======
public class Reader implements Serializable{
>>>>>>> 9d87868fbefe3083b557a62470d8feff6f02f7c9
    private String name;
    private String lastname;
    private String phone;

    public Reader() {
    }

    public Reader(String name, String lastname, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Reader{" 
                + "name=" + name 
                + ", lastname=" + lastname 
                + ", phone=" + phone 
                + '}';
    }
      
            
}
