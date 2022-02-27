/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.RequestDao;
import com.zema.isms.domain.Request;
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
public class RequestDaoImpl implements RequestDao{
     @Autowired
   private SessionFactory sessionFactory;
    @Override
    public void saveRequest(Request r) {
        sessionFactory.getCurrentSession().save(r);
    }

    @Override
    public void updateRequest(Request r) {
 sessionFactory.getCurrentSession().update(r);
    }

    @Override
    public void deleteRequest(Request r) {
       sessionFactory.getCurrentSession().delete(r);
    }

    @Override
    public void deleteRequest(String RequestId) {
       
    }

    @Override
    public Request findByRequestId(String RequestId) {
        Session session = sessionFactory.getCurrentSession(); 
           Request request = null;
           try{
          String hql= "FROM Request r LEFT JOIN FETCH r.user u LEFT JOIN FETCH u.empployee e LEFT JOIN FETCH e.department d WHERE r.requestId =:RequestId";
          Query<Request> query =session.createQuery(hql,Request.class);
          query.setParameter("RequestId",RequestId);
         
             request=query.getSingleResult();
           }
           catch(NoResultException ex){
               
           }
          return request;
     
    }

    @Override
    public List<Request> findAllRequest() {
    Session session = sessionFactory.getCurrentSession(); 
           List<Request> listrequest = null;
           try{
          String hql= "FROM Request r";
          Query<Request> query =session.createQuery(hql,Request.class);
         listrequest=query.list();
           }
           catch(NoResultException ex){
               
           }
          return listrequest;
     
    }

    @Override
    public List<Request> findAllRequestByDepartment(String departmentId, Integer statusStage) {
        
         Session session = sessionFactory.getCurrentSession(); 
           List<Request> listrequest = null;
           try{
          String hql= "FROM Request r LEFT JOIN FETCH r.user u LEFT JOIN FETCH u.empployee e LEFT JOIN FETCH e.department d WHERE d.departmentId =:departmentId  AND r.statusStage =:statusStage";
          Query<Request> query =session.createQuery(hql,Request.class);
          query.setParameter("departmentId",departmentId);
          query.setParameter("statusStage",statusStage);
         
          listrequest=query.list();
           }
           catch(NoResultException ex){
               
           }
          return listrequest;
     
    }

    @Override
    public Request getByRequestId(String RequestId) {
           Session session = sessionFactory.getCurrentSession();
    Request request =   session.get(Request.class, RequestId);
     return  request;
    }

    @Override
    public List<Request> retriveAllRequestByStatus(boolean status) {
          Session session = sessionFactory.getCurrentSession(); 
           List<Request> listrequest = null;
           try{
          String hql= "FROM Request r LEFT JOIN FETCH r.user u LEFT JOIN FETCH u.empployee e LEFT JOIN FETCH e.department d WHERE r.status =:status";
          Query<Request> query =session.createQuery(hql,Request.class);
          query.setParameter("status",status);
         
          listrequest=query.list();
           }
           catch(NoResultException ex){
               
           }
          return listrequest;
    }

 

    @Override
    public List<Request> retriveAllRequestByStatusStage(Integer statusStage) {
               Session session = sessionFactory.getCurrentSession(); 
           List<Request> listrequest = null;
           try{
          String hql= "FROM Request r LEFT JOIN FETCH r.user u LEFT JOIN FETCH u.empployee e LEFT JOIN FETCH e.department d WHERE r.statusStage =:statusStage";
          Query<Request> query =session.createQuery(hql,Request.class);
          query.setParameter("statusStage",statusStage);
         
          listrequest=query.list();
           }
           catch(NoResultException ex){
               
           }
          return listrequest;
    }



    @Override
    public List<Request> retriveBystatusStageAndUser(Integer statusStage, String userId) {
         Session session = sessionFactory.getCurrentSession(); 
           List<Request> listrequest = null;
           try{
          String hql= "FROM Request r LEFT JOIN FETCH r.user u  WHERE r.statusStage =:statusStage AND u.userId =:userId";
          Query<Request> query =session.createQuery(hql,Request.class);
          query.setParameter("statusStage",statusStage);
          query.setParameter("userId",userId);
          listrequest=query.list();
           }
           catch(NoResultException ex){
               
           }
          return listrequest;    
    }

    
}
