package com.capgemini.model;
import javax.persistence.*;

 

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class RTOOfficer {
    @Id
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name="officeid")
    private RTOOffice office;
    
    
    public RTOOfficer() {
        super();
    }

 


    public RTOOfficer(String username, String password, RTOOffice office) {
        super();
        this.username = username;
        this.password = password;
        this.office = office;
    }

 


    public String getUsername() {
        return username;
    }

 


    public void setUsername(String username) {
        this.username = username;
    }

 


    public String getPassword() {
        return password;
    }

 


    public void setPassword(String password) {
        this.password = password;
    }

 


    public RTOOffice getOffice() {
        return office;
    }

 


    public void setOffice(RTOOffice office) {
        this.office = office;
    }

 


    @Override
    public String toString() {
        return "RTOOfficer [username=" + username + ", password=" + password + ", office=" + office + "]";
    }
    
    
    
}
