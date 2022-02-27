/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.DepartmentDao;

import com.zema.isms.domain.Department;


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
public class DepartmentDaoImpl    implements DepartmentDao{
      @Autowired
   private SessionFactory sessionFactory;
    @Override
    public void saveDepartment(Department d) {
      sessionFactory.getCurrentSession().save(d);
        
    }

    @Override
    public void updateDepartment(Department d) {
             sessionFactory.getCurrentSession().update(d);
        
    }

    @Override
    public void deleteDepartment(Department d) {
             sessionFactory.getCurrentSession().delete(d);
    }
// not used currently
    @Override
    public void deleteDepartment(String departmentId) {
       sessionFactory.getCurrentSession().delete(departmentId);
    }

    @Override
    public Department findByDepartmentId(String departmentId) {
     Session session = sessionFactory.getCurrentSession();
     Department dept = session.get(Department.class, departmentId);
     return dept;
    }

    @Override
    public List<Department> findAllDepartment() {
        Session session = sessionFactory.getCurrentSession();
		 CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Department> cq = cb.createQuery(Department.class);
		Root<Department> root = cq.from(Department.class);
		cq.select(root);
        	Query<Department> query = session.createQuery(cq);
               List<Department> rsults = query.getResultList();
		return rsults;
    }

    @Override
    public List<Department> findByProperty(String propName, Object propValue) {
         return null;    
                 
    }
/*
    @Override
    public List<Department> findAllByOrganizationId(String organizationId) {
               Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Organization as o WHERE o.organizationId="+organizationId);
		Organization org = (Organization)query.uniqueResult();
		return new ArrayList<>(org.getDepartments());
    }
*/

    @Override
    public Department getDepartmentByName(String deptName) {
        Session session = null;
       Department dept = null;
        try{
           session = sessionFactory.getCurrentSession();
            String hql = "FROM Department d where d.name =:deptName";
            Query<Department> query = session.createQuery(hql);
            query.setParameter("deptName",deptName);
	          dept = query.getSingleResult();
        }
        catch(NoResultException ex){
           dept = null;
        }
        return dept;
    }

    @Override
    public int getDepartmentCount() {
            Session session = sessionFactory.getCurrentSession(); 
        int departmentCount =0;
      try{
         
         String hql ="FROM Department d";
          Query query = session.createQuery(hql);
       departmentCount =  query.getResultList().size();
      }
      catch(NoResultException e){
          
      }
      return  departmentCount;
    }
    }
    

