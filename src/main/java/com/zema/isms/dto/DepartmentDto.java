/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dto;

import com.zema.isms.domain.Organization;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public class DepartmentDto {
       
    private String depatmentId;
   
    private String name;
     
    private String phone;
    
    private String email;
       
    private List< Organization> organization; 

    public String getDepatmentId() {
        return depatmentId;
    }

    public void setDepatmentId(String depatmentId) {
        this.depatmentId = depatmentId;
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

    public List<Organization> getOrganization() {
        return organization;
    }

    public void setOrganization(List<Organization> organization) {
        this.organization = organization;
    }
    
    
}
