/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dto;

import com.zema.isms.validator.UniqueUserName;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ewawuye
 */
public class UserDto {
    
	
        @UniqueUserName
        @NotNull(message ="user name is not null")
        private String username;
        @NotNull(message ="password is not null")
        private String password;
	    @NotNull(message ="Confirm Password is not null")
	private String confirmPassword;
        
	private boolean enable;
        private Timestamp recordCreated;
        private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Timestamp getRecordCreated() {
        return recordCreated;
    }

    public void setRecordCreated(Timestamp recordCreated) {
        this.recordCreated = recordCreated;
    }
        
        
}
