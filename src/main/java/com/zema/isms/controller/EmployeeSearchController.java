/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Department;
import com.zema.isms.domain.Employee;
import com.zema.isms.dto.EmployeeDto;
import com.zema.isms.service.DepartmentService;
import com.zema.isms.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ewawuye
 */
@Controller
@RequestMapping("/manage")
public class EmployeeSearchController {
        @Autowired
    private EmployeeService empservice;
            @Autowired
    private DepartmentService departmentservice;
            
                @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
           // return manage page
    @RequestMapping(value = "/empManage",method = RequestMethod.GET)
    public ModelAndView getManageEmployee(){
        ModelAndView mv =new ModelAndView("manageEmployee");
     return mv;
    }
       // return manage page
    @RequestMapping(value = "/employee_search",method = RequestMethod.GET)
   public String searchEmployee(@RequestParam("searchText")String searchText, Model m){
         
               Employee emp = empservice.searchByEmployeeCode(searchText);
               if(emp==null){
                   m.addAttribute("message", "No employee by this Employee Id");
               }
               else{
            
             EmployeeDto emps  =convertEmployeeEntityToEmployeeDto(emp);
       
      // add to model
        
             
               m.addAttribute("emps",emps);
               }
        return "manageEmployee";  
       

   }
           @RequestMapping(value  ="/empEditGet" , method = RequestMethod.GET)
  public String geteditEmployee(@RequestParam("employeeId") String employeeId,Model m){
               List<Department> depts =departmentservice.getDepartmentList();
            

               m.addAttribute("departments",depts );
       
        Employee emp =empservice.searchByEmployeeId(employeeId);
        EmployeeDto empDto  =convertEmployeeEntityToEmployeeDto(emp);
       
      // add to model
         m.addAttribute("employee", empDto);
      
      return "editEmployee";  // redirect to employee page 
  }
   @RequestMapping(value = "/search_emp1", method = RequestMethod.GET)
    public  ModelAndView  SearchEmployee(@RequestParam(name = "firstName",required = false)String firstName,@RequestParam(name = "middleName",required = false)String middleName,@RequestParam(name = "lastName",required = false)String lastName , Model m){
ModelAndView mv =new ModelAndView("SearchEmpByName");
          List<Employee> empList1 = null;
         if(firstName !=null  ){
            empList1 = empservice.getEmployeeByFirstName(firstName);
         }
           if(middleName !=null){
               empList1 = empservice.getEmployeeByMiddleName(middleName);
           }
         if(lastName !=null){
               empList1 = empservice.getEmployeeByLastName(lastName);
           }
   EmployeeDto empDto = new EmployeeDto();
   List<EmployeeDto> searchEmp = new ArrayList<>();
   for( Employee e : empList1){
    
     empDto=convertEmployeeEntityToEmployeeDto(e);
 
        searchEmp.add(empDto );
  }
       
     if(searchEmp==null){
              
                     mv.addObject("message", "No employee by this Employee Name");
               }
     else{
   mv.addObject("emp", searchEmp);
     }
     
        
       
         
       
    return mv; 
    }
    
    
    
     @RequestMapping(value = "/search-employee",method = RequestMethod.GET)
    public ModelAndView getSearchEmployee(){
        ModelAndView mv =new ModelAndView("SearchEmpByName");
     return mv;
    }
    
    
    
    
        private EmployeeDto convertEmployeeEntityToEmployeeDto(Employee e){
         
     EmployeeDto empDto = new EmployeeDto();
    
      empDto.setEmployeeId(e.getEmployeeId());
      empDto.setFirstName(e.getFirstName());
      empDto.setMiddleName(e.getMiddleName());
      empDto.setLastName(e.getLastName());
      empDto.setCode(e.getCode());
      empDto.setAge(e.getAge());
      empDto.setEmail(e.getEmail());
      empDto.setGender(e.getGender());
      empDto.setPhone(e.getPhone());
      empDto.setJobPosition(e.getJobPosition());
      empDto.setDepartment(e.getDepartment());
 
     return  empDto;
 }
  
  
  
  
 
}
