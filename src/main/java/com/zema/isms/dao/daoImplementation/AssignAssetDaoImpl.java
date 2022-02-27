/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.AssigndAssetDao;
import com.zema.isms.domain.AssignedAsset;
import java.util.List;
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
public class AssignAssetDaoImpl  implements AssigndAssetDao{
  @Autowired
   private SessionFactory sessionFactory;
    @Override
    public void saveAssignedAsset(AssignedAsset a) {
     sessionFactory.getCurrentSession().save(a);
    }

    @Override
    public void updateAssignedAsset(AssignedAsset a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAssignedAsset(AssignedAsset a) {
         sessionFactory.getCurrentSession().delete(a);
    }

    @Override
    public AssignedAsset getAssignedAssetById(String id) {
        return sessionFactory.getCurrentSession().get(AssignedAsset.class, id);
    }

    @Override
    public List<AssignedAsset> getAllAssignedAsset() {
          Session session = sessionFactory.getCurrentSession(); 
          String hql= "FROM AssignedAsset aa ";
          Query<AssignedAsset> query =session.createQuery(hql,AssignedAsset.class);
         
          List<AssignedAsset> assignedAssets =query.list();
          return assignedAssets;
    }
    
}
