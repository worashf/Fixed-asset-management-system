/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Department;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface DepartmentService {
    
    /**
     * save  department information
     * @param d 
     */
   public  void registerDepartment(String orgId,Department d);
   /**
    * update department information
    * @param d 
    */
    public void editDepartment(Department d);
   /**
    * 
    * @param departmentId 
    */
    public void  removeDepartment(Department d );
   /**
    * 
    * @param departmentId
    * @return 
    */
    public Department searchByDepartmentId(String departmentId);
   
    public List<Department> getDepartmentList();
    public List<Department> getDepartmentListByOrgId(String orgId);
    public Department searchDepartmentByName(String name);
    public int retriveDepartmentCount();
}
