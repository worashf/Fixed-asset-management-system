/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.Employee;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface EmployeeDao {    
    public void saveEmployee(Employee e);

    public void updateEmployee(Employee e);

    public void deleteEmployee(Employee e);

    public void deleteEmployee(String employeeeId);

    public Employee  findByEmployeeId(String employeeId);
    public Employee  findByEmployeeCode(String code);
    public Employee  findByFirstName(String fname);


    public List<Employee> findAllEmployee();
    public List<Employee>  findByDepartmentId(String   departmentId);

     public Employee findEmployeeFirstName(String name);
     /**
      * get employee with is assets
      */  
     public Employee findAssetWithEmployee(String employeeId);
    public List<Employee> findEmployeeByFirstName(String firstName);
      public List<Employee> findEmployeeByMiddleName(String middleName);
        public List<Employee> findEmployeeByLastName(String lastName);
   
     
     
     
     

   
    
    
}
