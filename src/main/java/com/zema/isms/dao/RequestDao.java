/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.Request;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface RequestDao {
   public void saveRequest (Request r);

    public void updateRequest (Request r);

    public void deleteRequest (Request r);

    public void deleteRequest (String RequestId);

    public Request    findByRequestId(String RequestId);
     public Request    getByRequestId(String RequestId);
   
    public List<Request> findAllRequest ();
    public List<Request> findAllRequestByDepartment (String departmentId, Integer statusStage);
    public List<Request> retriveAllRequestByStatus (boolean status);
    
    public List<Request> retriveAllRequestByStatusStage (Integer statusStage);
    
    public List<Request> retriveBystatusStageAndUser (Integer statusStage,String userId);

}
