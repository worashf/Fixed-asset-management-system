/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.User;

import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface UserDao {
 public void saveUser (User u);

    public void updateUser (User u);

    public void deleteUser (User u);

    public void deleteUser (String userId);

    public User     findByUserId(String userId);
    
    public User     findByUserName(String userName);

    public List<User> findAllUser ();
    public List<User> findAllUserIsAcrive (boolean  enabled);
    public List<User> findAllUserNotActive(boolean  enabled);
   
}
