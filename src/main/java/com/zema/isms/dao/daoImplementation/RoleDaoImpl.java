/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.RoleDao;
import com.zema.isms.domain.SystemRole;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ewawuye
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
   private SessionFactory sessionFactory;
    @Override
    public void saveRole(SystemRole r) {
      sessionFactory.getCurrentSession().save(r);
    }

    @Override
    public void updateRole(SystemRole r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRole(SystemRole r) {
        sessionFactory.getCurrentSession().delete(r);
    }

    @Override
    public void deleteAsset(String AssetId) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemRole findByRoletId(String RoleId) {
        SystemRole role = sessionFactory.getCurrentSession().get(SystemRole.class, RoleId);
        return  role;
    }

    @Override
    public SystemRole findByRoleName(String roleName) {
     SystemRole role = null;
         try{
             Session session = sessionFactory.getCurrentSession();
            String hql = "FROM SystemRole r WHERE  r.name = :roleName";
             Query query = session.createQuery(hql,SystemRole.class);
             query.setParameter("roleName", roleName);
             role =  (SystemRole) query.getSingleResult();
         }
   catch(NoResultException nre){
       role =null;
   }
       return role;   
    }

    @Override
    public List<SystemRole> findAllRole() {
             List<SystemRole> roles = null;
         try{
             Session session = sessionFactory.getCurrentSession();
            String hql = "FROM SystemRole r ";
             Query query = session.createQuery(hql,SystemRole.class);
             roles = query.getResultList();
         }
   catch(NoResultException nre){
       roles =null;
   }
          return roles;
    }
      
  }
