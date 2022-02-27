/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.CatagoryDao;

import com.zema.isms.domain.Catagory;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class CatagoryDaoImpl   implements CatagoryDao{
    @Autowired
   private SessionFactory sessionFactory;

    @Override
    public void saveCatagory(Catagory c) {
        sessionFactory.getCurrentSession().save(c);
       
    }
    @Override
    public void updateCatagory(Catagory c) {
        sessionFactory.getCurrentSession().update(c);
    }

    @Override
    public void deleteCatagory(String catagoryId) {
      Session session = sessionFactory.getCurrentSession();
         Catagory catagory = ( Catagory) session.get(Catagory.class, catagoryId);
         session.delete(catagory);
    }

    // not used currently
    @Override
    public void deleteCatagory(Catagory c) {
        sessionFactory.getCurrentSession().delete(c);
 
    }

    @Override
    public Catagory findByCatagoryId(String catagoryId) {
        //Catagory catagory = (Catagory) sessionFactory.getCurrentSession().load(Catagory.class, catagoryId);
              Session session = sessionFactory.getCurrentSession();
         Catagory catagory = ( Catagory) session.get(Catagory.class, catagoryId);
        return catagory; 
    }

    @Override
    public List<Catagory> findAllCatagory() {
   //List<Catagory> catagorys = (List<Catagory>)sessionFactory.getCurrentSession().createQuery("from catagory").list();
   // String hql = "from Catagory";
   // Query query = sessionFactory.getCurrentSession().createQuery(hql);
            
           // List results = query.getResultList();
           //List<Catagory> categories = query.list();
              Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Catagory> cq = cb.createQuery(Catagory.class);
		Root<Catagory> root = cq.from(Catagory.class);
		cq.select(root);
		Query query = (Query) session.createQuery(cq);
		return query.getResultList();
        
    }

    @Override
    public List<Catagory> findByProperty(String propName, Object propValue) {
        return null;  
    }

    @Override
    public Catagory getCatagoryByName(String catagoryName) {
        Session session =null;
        Catagory cat = null;
        try{
            session = sessionFactory.getCurrentSession();
            String hql = "FROM  Catagory  c where c.catagoryName =:catagoryName";
            Query query = session.createQuery(hql, Catagory.class);
            query.setParameter("catagoryName",catagoryName);
	        cat =  (Catagory) query.getSingleResult();
        }
        catch(NoResultException ex){
            cat =null;
        }
        return cat;
    }

    @Override
    public int getCategoryCount() {
             Session session = sessionFactory.getCurrentSession(); 
        int catagoryCount =0;
      try{
         
         String hql ="FROM Catagory c";
          Query query = session.createQuery(hql);
      catagoryCount =  query.getResultList().size();
      }
      catch(NoResultException e){
          
      }
      return  catagoryCount;
    }
    
    
}
