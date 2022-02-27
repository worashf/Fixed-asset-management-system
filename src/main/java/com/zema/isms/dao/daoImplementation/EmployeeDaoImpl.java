/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.AssetDao;
import com.zema.isms.dao.EmployeeDao;

import com.zema.isms.domain.Department;

import com.zema.isms.domain.Employee;
import java.util.ArrayList;

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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Repository
public class EmployeeDaoImpl  implements  EmployeeDao{
     @Autowired
   private SessionFactory sessionFactory;
          @Autowired
     private AssetDao assetdao;
    @Override
    public void saveEmployee(Employee e) {
          
        sessionFactory.getCurrentSession().save(e);
    }

    @Override
    public void updateEmployee(Employee e) {
      sessionFactory.getCurrentSession().update(e);
       
    }

    @Override
    public void deleteEmployee(Employee e) {
   sessionFactory.getCurrentSession().delete(e);
       
    }

    @Override
    public void deleteEmployee(String employeeId) {
 
    }

    @Override
    public Employee findByEmployeeId(String employeeId) {
       
     Session session = sessionFactory.getCurrentSession();
     Employee emp = session.get(Employee.class, employeeId);
     return emp;
    }

    @Override
    @Transactional
    public Employee findByEmployeeCode(String code) {
  
        
                
        
       Employee emp = null;
        try{
    Session session = sessionFactory.getCurrentSession();
    
    String hql="from Employee e where e.code=:code";
      Query query = session.createQuery(hql,Employee.class);
     query.setParameter("code", code);
      emp = (Employee) query.getSingleResult();
     }
        catch(NoResultException nre) {
			
        }
        return emp;
    }

    @Override
    public List<Employee> findAllEmployee() {
           
        Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
    }



    @Override
    public List<Employee> findByDepartmentId(String departmentId) {
       Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Department as d WHERE d.depatmentId=:departmentId");
                query.setParameter("departmentId", departmentId);
		Department dept = (Department)query.uniqueResult();
		return new ArrayList<>(dept.getEmployee());
    }

    @Override
    public Employee findByFirstName(String fname) {
       //  Session session = sessionFactory.getCurrentSession();
      //  String hql="from Employee e where e.firstName LIKE '%fname%'";
       // Query q = session.createQuery(hql);
      //  return  (Employee) q.getSingleResult();
        return null;
        
    }
    /**
 * search asset by name or brand
 * @param name
 * @return 
 */
    @Override
    public Employee findEmployeeFirstName(String name) {
    Session session = sessionFactory.getCurrentSession();
     CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
    Root<Employee> root = cr.from(Employee.class);
         
    cr.select(root).where(cb.equal(root.get("firstName"),name));
    Query<Employee> query = session.createQuery(cr);
    return query.getSingleResult();

    }

    @Override
    public Employee findAssetWithEmployee(String employeeId) {
       Session session = sessionFactory.getCurrentSession();
       String hql ="FROM Employee e LEFT JOIN FETCH e.assets WHERE e.employeeId=:employeeId";
       Query<Employee>q=session.createQuery(hql,Employee.class);
       q.setParameter("employeeId",employeeId);
       Employee emp = (Employee) q.uniqueResult();
     return emp;
    }

  
 @Override
     public  List<Employee> findEmployeeByFirstName(String firstName){
        Session session = null;
         
         List<Employee> employeeList = null;
         try{
            session = sessionFactory.getCurrentSession();
      String hql  = "FROM Employee e WHERE e.firstName=:firstName"; 
       Query query = session.createQuery(hql); 
       query.setParameter("firstName",firstName);
       employeeList =  query.list();
         }
   catch(NoResultException ex){
       employeeList = null;
   }
     
          
        return  employeeList ;
  }
     
      @Override
      public List<Employee> findEmployeeByMiddleName(String middleName){
                Session session =null;
         
         List<Employee> employeeList = null;
         try{
             session = sessionFactory.getCurrentSession();
      String hql  = "FROM Employee e WHERE e.middleName=:middleName "; 
       Query query = session.createQuery(hql); 
      
          query.setParameter("middleName",middleName);
         
           employeeList =  query.list();
         }
   catch(NoResultException ex){
       employeeList = null;
   }
     
          
        return  employeeList ;
      }
       @Override
      public List<Employee> findEmployeeByLastName(String lastName){
                Session session = null;
         
         List<Employee> employeeList = null;
         try{
             session = sessionFactory.getCurrentSession();
      String hql  = "FROM Employee e WHERE  e.lastName=:lastName"; 
       Query query = session.createQuery(hql); 
      
             query.setParameter("lastName",lastName);
           employeeList =  query.list();
         }
   catch(NoResultException ex){
       employeeList = null;
   }
     
          
        return  employeeList ;  
        }
    
}
