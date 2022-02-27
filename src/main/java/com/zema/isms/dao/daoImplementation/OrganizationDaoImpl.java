/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.OrganizationDao;
import com.zema.isms.domain.Catagory;

import com.zema.isms.domain.Organization;

import java.util.List;
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
public class OrganizationDaoImpl   implements OrganizationDao {
   @Autowired
   private SessionFactory sessionFactory;
    @Override
    public void saveOrganization(Organization o) {
        
      sessionFactory.getCurrentSession().save(o);
    }

    @Override
    public void updateOrganization(Organization o) {
          // Retrieve session from Hibernate
       Session session=    sessionFactory.getCurrentSession();
       
        // Retrieve existing organization via id
  Organization existingOrganization = (Organization) session.get(Organization.class, o.getOrganizationId());
  
  // Assign updated values to this Organization

  existingOrganization.setName(o.getName());
  existingOrganization.setAddress(o.getAddress());
  existingOrganization.setCity(o.getCity());
  existingOrganization.setPhone(o.getPhone());
  existingOrganization.setEmail(o.getEmail());
  existingOrganization.setCountry(o.getCountry());
  existingOrganization.setDescription(o.getDescription());
 
  

  // Save updates
  session.save(existingOrganization);
    }

    @Override
    public void deleteOrganization(Organization o) {
      sessionFactory.getCurrentSession().delete(o);
    }
 // not used previously
    @Override
    public void deleteOrganization(String organizationId) {
        sessionFactory.getCurrentSession().delete(organizationId);
    }

    @Override
    public Organization findByOrganizationId(String organizationId) {
        
        Session session =sessionFactory.getCurrentSession();
        Organization org = session.get(Organization.class,  organizationId);
           return org;
    }

    @Override
    public List<Organization> findAllOrganization() {
        
        Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Organization> cq = cb.createQuery(Organization.class);
		Root<Organization> root = cq.from(Organization.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();  
        
        
    }
  

    @Override
    public List<Organization> findByProperty(String propName, Object propValue) {
          return null;
    }

    @Override
    public Organization getByOrgName(String orgName) {
 
		 
   Session session = sessionFactory.getCurrentSession();
 CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Organization> query = builder.createQuery(Organization.class);
         Root<Organization> root = query.from(Organization.class);
         query.select(root).where(builder.equal(root.get("name"), orgName));
         Query<Organization> q=session.createQuery(query);
         Organization org =q.getSingleResult();
return org;
    }
    
}
