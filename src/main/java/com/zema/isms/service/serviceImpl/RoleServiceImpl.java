/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.RoleDao;
import com.zema.isms.domain.SystemRole;
import com.zema.isms.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Service
public class RoleServiceImpl implements RoleService{
   
    @Autowired
    private RoleDao roledao;
    @Transactional
    @Override
    public void registerSystemRole(SystemRole sr) {
       roledao.saveRole(sr);
    }

    @Override
    public void editSystemRole(SystemRole sr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  @Transactional
    @Override
    public void removeSystemRole(SystemRole sr) {
         roledao.deleteRole(sr);
    }
@Transactional
    @Override
    public SystemRole searchBySystemRoleId(String roleId) {
      return  roledao.findByRoletId(roleId);
    }
   @Transactional
    @Override
    public List<SystemRole> getSystemRoleList() {
      return  roledao.findAllRole();
    }
   @Transactional
    @Override
    public SystemRole searchSystemRoleByName(String name) {
        return  roledao.findByRoleName(name);
    }
    
}
