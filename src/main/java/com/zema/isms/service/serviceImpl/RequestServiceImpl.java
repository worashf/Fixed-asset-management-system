/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.RequestDao;
import com.zema.isms.domain.Request;
import com.zema.isms.service.RequestService;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author ewawuye
 */
@Service
public class RequestServiceImpl implements RequestService{
    @Autowired
private RequestDao requestdao;
    @Transactional
    @Override
    public void addRequest(Request r) {
     requestdao.saveRequest(r);
    }
  @Transactional
    @Override
    public void editRequest(Request request) {
       Request request1 =requestdao.getByRequestId(request.getRequestId());
       request1.setRequestId(request1.getRequestId());
       request1.setItem1(request.getItem1());
       request1.setItem2(request.getItem2());
       request1.setItem3(request.getItem3());
       request1.setItem4(request.getItem4());
       request1.setItem5(request.getItem5());
       request1.setQuantity1(request.getQuantity1());
       request1.setQuantity2(request.getQuantity2());
       request1.setQuantity3(request.getQuantity3());
       request1.setQuantity4(request.getQuantity4());
       request1.setQuantity5(request.getQuantity5());
       request1.setApproved1(request.getApproved1());
       request1.setApproved2(request.getApproved2());
       request1.setApproved3(request.getApproved3());
       request1.setApproved4(request.getApproved4());
       request1.setApproved5(request.getApproved5());
       request1.setDescription(request.getDescription());
      // request1.setStatus(true);
       request1.setStatusStage(1);
        requestdao.updateRequest(request1);
    }
  @Transactional
    @Override
    public void removeRequest(Request r) {
          requestdao.deleteRequest(r);
    }
    @Transactional
    @Override
    public Request getByRequestId(String RequestId) {
    return requestdao.findByRequestId(RequestId);
    }
    @Transactional
    @Override
    public List<Request> getAllRequest() { 
        List<Request> listrequest = null;
    
        try {
       listrequest =  requestdao.findAllRequest();
        }
        catch(NoResultException ex){
             
         }
        return listrequest;
    }
    @Transactional
    @Override
    public List<Request> getRequestListByDepartment(String departmentId) {
        List<Request> listrequest = null;
        try{
          listrequest =  requestdao.findAllRequestByDepartment(departmentId,0);
        }
         catch(NoResultException ex){
             
         }
        return listrequest;
    }
    @Transactional
    @Override
    public Request searchByRequestId(String RequestId) {
       return  requestdao.getByRequestId(RequestId);
    }
    @Transactional
    @Override
    public List<Request> searchRequestListByStatus(boolean status) {
          List<Request> listrequest = null;
        try{
          listrequest =  requestdao.retriveAllRequestByStatus(status);
        }
         catch(NoResultException ex){
             
         }
        return listrequest;
    }
@Transactional
    @Override
    public void updateRequest(Request r) {
      requestdao.updateRequest(r);
    }

   @Transactional
    @Override
    public List<Request> searchRequestListByStatusStage(Integer statusStage) {
               List<Request> listrequest = null;
        try{
          listrequest =  requestdao.retriveAllRequestByStatusStage(statusStage);
        }
         catch(NoResultException ex){
             
         }
        return listrequest;
    }
  @Transactional
    @Override
    public void editRequestByMnager(Request request) {
        
         Request request1 =requestdao.getByRequestId(request.getRequestId());
       request1.setRequestId(request1.getRequestId());
       request1.setItem1(request.getItem1());
       request1.setItem2(request.getItem2());
       request1.setItem3(request.getItem3());
       request1.setItem4(request.getItem4());
       request1.setItem5(request.getItem5());
       request1.setQuantity1(request.getQuantity1());
       request1.setQuantity2(request.getQuantity2());
       request1.setQuantity3(request.getQuantity3());
       request1.setQuantity4(request.getQuantity4());
       request1.setQuantity5(request.getQuantity5());
       request1.setApproved1(request.getApproved1());
       request1.setApproved2(request.getApproved2());
       request1.setApproved3(request.getApproved3());
       request1.setApproved4(request.getApproved4());
       request1.setApproved5(request.getApproved5());
       request1.setDescription(request.getDescription());
        request1.setDescription(request.getManagerComment());
      //manager aprove stage
       request1.setStatusStage(3);
        requestdao.updateRequest(request1);
    }
  @Transactional
    @Override
    public void editRequestByKepeer(Request request) {

         Request request1 =requestdao.getByRequestId(request.getRequestId());
       request1.setRequestId(request1.getRequestId());
       request1.setItem1(request.getItem1());
       request1.setItem2(request.getItem2());
       request1.setItem3(request.getItem3());
       request1.setItem4(request.getItem4());
       request1.setItem5(request.getItem5());
       request1.setQuantity1(request.getQuantity1());
       request1.setQuantity2(request.getQuantity2());
       request1.setQuantity3(request.getQuantity3());
       request1.setQuantity4(request.getQuantity4());
       request1.setQuantity5(request.getQuantity5());
       request1.setApproved1(request.getApproved1());
       request1.setApproved2(request.getApproved2());
       request1.setApproved3(request.getApproved3());
       request1.setApproved4(request.getApproved4());
       request1.setApproved5(request.getApproved5());
       request1.setDescription(request.getDescription());
        request1.setDescription(request.getManagerComment());
      //manager aprove stage
       request1.setStatusStage(5);
        requestdao.updateRequest(request1);
    }
@Transactional
    @Override
    public List<Request> getByDeclinBytDirecterAndUser(Integer declineStage, String userId) {
           List<Request> listrequest = null;
        try{
          listrequest =  requestdao.retriveBystatusStageAndUser(declineStage, userId);
        }
         catch(NoResultException ex){
             
         }
        return listrequest; 
    }
@Transactional
    @Override
    public List<Request> getCompletedRequestBytStatusStageAndUser(Integer statusStage, String userId) {
               List<Request> listrequest = null;
        try{
          listrequest =  requestdao.retriveBystatusStageAndUser(statusStage, userId);
        }
         catch(NoResultException ex){
             
         }
        return listrequest; 
    }
    
}
