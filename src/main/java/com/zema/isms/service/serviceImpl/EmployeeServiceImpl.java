/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.DepartmentDao;
import com.zema.isms.dao.EmployeeDao;

import com.zema.isms.domain.Department;
import com.zema.isms.domain.Employee;
import com.zema.isms.dto.EmployeeDto;
import com.zema.isms.service.EmployeeService;

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
@Transactional
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeDao empdao;
        @Autowired
    private DepartmentDao  deptdao;
    @Override
    public Employee registerEmployee(String departmentId,Employee e ){
      
            
      
        Employee emp = new Employee();
        Department dept = deptdao.findByDepartmentId(departmentId);
  
        emp.setEmployeeId(e.getEmployeeId());
        emp.setFirstName(e.getFirstName());
        emp.setMiddleName(e.getMiddleName());
        emp.setLastName(e.getLastName());
        emp.setAge(e.getAge());
        emp.setPhone(e.getPhone());
        emp.setEmail(e.getEmail());
        emp.setCode(e.getCode());
        emp.setGender(e.getGender());
        emp.setJobPosition(e.getJobPosition());
    
        emp.setDepartment(dept);
        
        dept.getEmployee().add(emp);
        empdao.saveEmployee(emp);
      return emp;  
        
    }

    @Override
    public void editEmployee(Employee e) {
    empdao.updateEmployee(e);
    }

    @Override
    public void removeEmployee(String employeeId) {
       
    }

    @Override
    public Employee searchByEmployeeId(String employeeId) {
          return  empdao.findByEmployeeId(employeeId);
    }

    @Override
    public Employee searchByEmployeeCode(String code) {
        Employee emp = null;
               
    try{
        emp = empdao.findByEmployeeCode(code);
    }
          catch(NoResultException ex){
              
          }
           return emp;

    }

    @Override
    public List<Employee> getEmployeeList() {
       return  empdao.findAllEmployee();
    }


    @Override
    public Employee searchEmployeeByfirstName(String fname) {
             return  empdao.findEmployeeFirstName(fname);
    }

    @Override
    public Employee searchEmployeeWithAsset(String employeeId) {
          return  empdao.findAssetWithEmployee(employeeId);
    }
/*
    to check if employee code is the same
    */
    
    @Override
    public boolean isEmployeeCodeInDb(String code) {
      boolean empCodeInDb= true;
      if(empdao.findByEmployeeCode(code)==null){
          empCodeInDb= false;
          
      }
      return empCodeInDb;
    }

   

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
         List<Employee>  emplist = null;
          try {
            emplist = empdao.findEmployeeByFirstName(firstName);
        } catch (NoResultException ex) {
            emplist = null;
        }
          return  emplist;
    }
    @Override
    public List<Employee> getEmployeeByMiddleName(String middleName) {
 List<Employee>  emplist = null;
          try {
            emplist = empdao.findEmployeeByMiddleName(middleName);
        } catch (NoResultException ex) {
            emplist = null;
        }
          return  emplist;
    }

    @Override
    public List<Employee> getEmployeeByLastName(String lastName) {
        List<Employee>  emplist = null;
          try {
            emplist = empdao.findEmployeeByLastName(lastName);
        } catch (NoResultException ex) {
            emplist = null;
        }
          return  emplist;
    }

    @Override
    public void removeEmployee(Employee emp) {
empdao.deleteEmployee(emp);
    }
  

    
}
