/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Employee;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author ewawuye
 */
public interface EmployeeService {
     /**
      * 
      * @param e 
      */
   public  Employee registerEmployee(String departmentId,Employee e )throws IOException;
   /**
    * 
    * @param e 
    */
    public void editEmployee(Employee e);
  /**
   * 
   * @param employeeId 
   */
    public void  removeEmployee(String employeeId );
       public void  removeEmployee(Employee emp );
    /**
     * 
     * @param employeeId
     * @return 
     */
    public Employee searchByEmployeeId(String employeeId);

     public Employee searchByEmployeeCode(String code);
    
    /**
     * 
     * @return 
     */
   public  Employee searchEmployeeWithAsset(String employeeId);
    public List<Employee> getEmployeeList();
    // List<Employee>  SearchAllEmplyeeInDepartment();
    //activate deactivate employee
   // public List<Employee>  getEmployeeByJobPosition(String);
    
    public  Employee searchEmployeeByfirstName(String fname);
    public boolean  isEmployeeCodeInDb(String code);
      public List<Employee> getEmployeeByFirstName(String firstName);
      public List<Employee> getEmployeeByMiddleName(String middleName);
        public List<Employee> getEmployeeByLastName(String lastName);
       
    
}
