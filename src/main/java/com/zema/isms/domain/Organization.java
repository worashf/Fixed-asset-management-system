/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author ewawuye
 */
@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    @Id
    @Column(name = "organizationId")
      @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String organizationId;
 
     @NotNull(message ="organization name is not null")
       @Column(name = "name")
    private String name;
     @Column(name = "phone")
      @NotNull(message ="organization phone is not null")
    private String phone;
 @Column(name = "email")
       @NotNull(message ="organization email is not null")
       @Email(message = "invalid email. please enter valid email ")
        
    private String email;
         @Column(name = "address")
         @NotNull(message ="organization address is not null")
    private String address;
   @Column(name = "city")
          @NotNull(message ="organization city is not null")
    private String city;
        @Column(name = "country")
           @NotNull(message ="organization country  is not null")
    private String country;
      @Column(name = "description")
    private String description;

      @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments = new ArrayList<Department>();     

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
