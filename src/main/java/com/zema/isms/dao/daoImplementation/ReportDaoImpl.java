/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.ReportDao;
import com.zema.isms.domain.AssignedAsset;
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
public class ReportDaoImpl  implements ReportDao{

     @Autowired
   private SessionFactory sessionFactory;
    @Override
    public List<AssignedAsset> getAssignedAssetByDepartment(String departmentId) {
          Session session = sessionFactory.getCurrentSession(); 
           List<AssignedAsset> assignedAssets = null;
           try{
          String hql= "FROM AssignedAsset aa LEFT JOIN FETCH aa.asset a LEFT JOIN FETCH a.catagory c LEFT JOIN FETCH  "
                  + "aa.employee e LEFT JOIN FETCH e.department d WHERE d.departmentId=:departmentId";
          Query<AssignedAsset> query =session.createQuery(hql,AssignedAsset.class);
          query.setParameter("departmentId",departmentId);

          assignedAssets =query.list();
           }
           catch(NoResultException ex){
               
           }
          return assignedAssets;
    }

    @Override
    public List<AssignedAsset> getAssignedAssetByCategory(String catagoryId) {
             Session session = sessionFactory.getCurrentSession(); 
            List<AssignedAsset> assignedAssets=null;
            try{
          String hql= "FROM AssignedAsset aa LEFT JOIN FETCH aa.asset a LEFT JOIN FETCH a.catagory c LEFT JOIN FETCH  "
                  + "aa.employee e LEFT JOIN FETCH e.department d WHERE c.catagoryId=:catagoryId";
          Query<AssignedAsset> query =session.createQuery(hql,AssignedAsset.class);
          query.setParameter("catagoryId",catagoryId);
         
            assignedAssets =query.list();
            }
            catch(NoResultException ex){
                
            }
          return assignedAssets;
    }

    @Override
    public List<AssignedAsset> getAssignedAssetByDepartmentAndCategory(String categoryId, String departmentId) {
        Session session = sessionFactory.getCurrentSession(); 
            List<AssignedAsset> assignedAssets = null;
            try{
          String hql= "FROM AssignedAsset aa LEFT JOIN FETCH aa.asset a LEFT JOIN FETCH a.catagory c LEFT JOIN FETCH  "
                  + "aa.employee e LEFT JOIN FETCH e.department d WHERE c.catagoryId=:categoryId AND d.departmentId =: departmentId";
          Query<AssignedAsset> query =session.createQuery(hql,AssignedAsset.class);
          query.setParameter("categoryId",categoryId);
          query.setParameter("departmentId", departmentId);
          
         assignedAssets =query.list();
            }
            catch(NoResultException ex ){
                
            }
          return assignedAssets;
    }

    
}
