/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.SystemRole;
import java.util.List;


public interface RoleService {
        
  
   public  void registerSystemRole(SystemRole sr);
  
    public void editSystemRole(SystemRole sr);
   
    public void  removeSystemRole(SystemRole sr );
  
    public SystemRole searchBySystemRoleId(String roleId);
   
    public List<SystemRole> getSystemRoleList();

    public SystemRole searchSystemRoleByName(String name);
}
