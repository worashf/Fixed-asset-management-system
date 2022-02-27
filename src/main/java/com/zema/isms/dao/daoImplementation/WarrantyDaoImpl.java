/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.WarrantyDao;
import com.zema.isms.domain.Asset;
import com.zema.isms.domain.waranty.Warranty;
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
public class WarrantyDaoImpl implements WarrantyDao {
      @Autowired
   private SessionFactory sessionFactory;

    @Override
    public void saveWarranty(Warranty w) {
         sessionFactory.getCurrentSession().save(w);
    }

    @Override
    public void updateWarranty(Warranty w) {
        sessionFactory.getCurrentSession().update(w);
    }

    @Override
    public void deleteWarranty(Warranty w) {
         sessionFactory.getCurrentSession().delete(w);
    }

    @Override
    public void deleteWarranty(String warrantyId) {
       
    }

    @Override
    public Warranty findByWarrantyId(String warrantyId) {
        Session session = sessionFactory.getCurrentSession();
        Warranty warranty = session.get( Warranty.class, warrantyId);
        return warranty;
    }

    @Override
    public List<Warranty> findAllWarranty() {
         return null;
    }

    @Override
    public List<Warranty> findByProperty(String propName, Object propValue) {
       return null;
    }

    @Override
    public Asset getAssetAdnwarrantyDocument(String assetCode) {
      Asset asset = null;
      try{
            Session session = sessionFactory.getCurrentSession(); 
          String hql = "FROM Asset a LEFT JOIN FETCH a.warranty w LEFT JOIN FETCH w.documents d WHERE a.assetCode =:assetCode";
      
            Query<Asset> query = session.createQuery(hql,Asset.class);
       query.setParameter("assetCode", assetCode);
       asset = (Asset)query.uniqueResult();
        }
        catch(NoResultException ex){
            
        }
      return asset;
    }
    
}
