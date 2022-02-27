/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.UserDao;
import com.zema.isms.domain.User;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Repository
public class UserDaoImpl  implements UserDao{
    @Autowired
   private SessionFactory sessionFactory;
  
    @Override
    public void saveUser(User u) {
        sessionFactory.getCurrentSession().save(u);
    }

    @Override
    public void updateUser(User u) {
        sessionFactory.getCurrentSession().update(u);
  
    }

    @Override
    public void deleteUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findByUserId(String userId) {
    User user = sessionFactory.getCurrentSession().get(User.class,userId);
       return user;
    }

    @Override
    public User findByUserName(String userName) {
        User user = null;
         try{
             Session session = sessionFactory.getCurrentSession();
            String hql = "FROM User u LEFT JOIN FETCH u.empployee e LEFT JOIN FETCH e.department d  WHERE u.username =:userName";
             Query query = session.createQuery(hql,User.class);
             query.setParameter("userName", userName);
             user = (User) query.getSingleResult();
         }
   catch(NoResultException nre){
       user =null;
   }
          return user;
    }  
    

    @Override
    public List<User> findAllUser() {
         List<User> user = null;
         try{
             Session session = sessionFactory.getCurrentSession();
            String hql = "FROM User u LEFT JOIN FETCH u.roles r ";
             Query query = session.createQuery(hql,User.class);
             user = (List<User>) query.getResultList();
         }
   catch(NoResultException nre){
       user =null;
   }
          return user;
    } 
    

    @Override
    public List<User> findAllUserIsAcrive(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAllUserNotActive(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
