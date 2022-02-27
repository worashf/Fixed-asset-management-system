/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Request;
import com.zema.isms.domain.User;
import com.zema.isms.dto.UserDto;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface UserService {
   
   public  void registerUser(UserDto u);
  
    public void editUser(User u);
   
    public void  removeUser(User u );
  
    public User searchByUserId(String userId);
   
    public List<User> getUserList();

    public User searchUserByName(String name); 
    public boolean  isUserNameInuse(String name);

    public void registerUserWithEmp(UserDto user, String employeeId);
   
}
