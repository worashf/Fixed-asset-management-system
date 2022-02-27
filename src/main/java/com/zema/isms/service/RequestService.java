/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Request;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface RequestService {
     public void addRequest (Request r);

    public void editRequest (Request r);
    public void editRequestByMnager (Request request);
    public void editRequestByKepeer (Request request);
    // for  decline
   public void updateRequest (Request r);
    public void removeRequest (Request r);
    // to get request and its associated user ,employee and department
    public Request getByRequestId(String RequestId);
    // to get only request by id
      public Request searchByRequestId(String RequestId);
     public List<Request> getAllRequest ();
     public List<Request> getRequestListByDepartment(String departmentId);
      public List<Request> searchRequestListByStatus(boolean status);
       public List<Request> getByDeclinBytDirecterAndUser(Integer declineStage, String userId);
       public List<Request> searchRequestListByStatusStage(Integer statusStage);
       public List<Request> getCompletedRequestBytStatusStageAndUser(Integer statusStage, String userId);
}
