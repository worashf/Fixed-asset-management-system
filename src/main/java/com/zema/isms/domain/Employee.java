/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;


import com.zema.isms.validator.UniqueEmployeeCode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ewawuye
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
     @Column(name = "employeeId")
    private String employeeId;
   @Column(name = "firstName")
   @NotNull(message = "first  name is not null")
    
    private String firstName;
   @Column(name = "middleName")
   @NotNull(message = "middle name is not null")
    
    private String middleName;
  @Column(name = "lastName")
    @NotNull(message = "last  name is not null")
    
    private String lastName;
   @Column(name = "age")
    private Integer age;
 @Column(name = "gender")
    private String gender;
  @Column(name = "phone")
    
    private String phone;
   @Column(name = "email")
    private String email;
    
   
     @Column(name = "code")
  
    private String code;   // Employee barcode id
   @Column(name = "jobPosition")
   // @NotNull(message = "job title is not null")
    private String jobPosition;
    // @Column(columnDefinition = "LONGLOB NOT NULL")
    // @Lob
    //@Type(type = "org.hibernate.type.MaterializedBlobType")
  //  private byte[] photo;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;
    @OneToMany(mappedBy ="employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List<Asset> assets;
    @OneToMany(mappedBy ="employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List <AssetHistory> emphistory;

      @OneToMany(mappedBy ="employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY )

   private List<AssignedAsset> assignedAsset;
   @OneToMany(mappedBy ="empployee",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
   private List<User> users;

    public List<AssetHistory> getEmphistory() {
        return emphistory;
    }

    public void setEmphistory(List<AssetHistory> emphistory) {
        this.emphistory = emphistory;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<AssignedAsset> getAssignedAsset() {
        return assignedAsset;
    }

    public void setAssignedAsset(List<AssignedAsset> assignedAsset) {
        this.assignedAsset = assignedAsset;
    }
      
    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
    

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

   

 

}
