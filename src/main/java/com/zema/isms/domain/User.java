/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;


import edu.emory.mathcs.backport.java.util.Collections;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ewawuye
 */
@Entity
@Table(name="user")
public class User implements Serializable {
     @Id
     @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
     @Column(name="userId")
       private String userId;
	
	@Column(name="username", unique=true)
	
	private String username;
	
	@Column(name="password")
	private String password;
          @Transient
        private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
	  
     @Column(name="enable")
	private boolean enable;
	
//	@Column(name="record_created")
//	private Timestamp recordCreated;
        @ManyToMany(
        cascade= {CascadeType.DETACH, CascadeType.MERGE,
		CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
				name="user_role",
				joinColumns=@JoinColumn(name="userId"),
				inverseJoinColumns=@JoinColumn(name="roleId"))
        private Set<SystemRole> roles;
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employeeId")
        private  Employee empployee;
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        private List<Request> request;

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }
     
    public Employee getEmpployee() {
        return empployee;
    }

    public void setEmpployee(Employee empployee) {
        this.empployee = empployee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

 

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SystemRole> roles) {
        this.roles = roles;
    }

 public void addRole(SystemRole role){
		
		if (roles == null){
			roles = new HashSet<SystemRole>();
		}
		
		roles.add(role);
	}
        
}
