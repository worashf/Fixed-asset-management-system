/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Department;
import com.zema.isms.domain.Organization;

import com.zema.isms.service.DepartmentService;
import com.zema.isms.service.OrganizationService;


import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author ewawuye
 */

@Controller
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentservice;
    
     @Autowired
    private OrganizationService organizationservice;
    
       @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
 
     
     @RequestMapping(value = "/dept_add", method = RequestMethod.GET)
     public String getDepartmentReg(Model m)
            
     {
      List<Organization> orgs = organizationservice.getOrganizationList();
         Department dept = new Department();
          // list depts 
       List<Department> depts = departmentservice.getDepartmentList();
       m.addAttribute("deptList", depts );
      // add to model
      m.addAttribute("department", dept);
      
         int count = departmentservice.retriveDepartmentCount();
        m.addAttribute("count",count);
          m.addAttribute("organizations",orgs);
       
        return "department";  
     }
         @RequestMapping( value ="/dept_registration", method = RequestMethod.POST)
    public String postDepartmentreg(@Valid
            @ModelAttribute("department")  Department dept,BindingResult result, Model m) {


             if(result.hasErrors()){
            
                
                   List<Organization> orgs = organizationservice.getOrganizationList();
                        m.addAttribute("organizations",orgs);
                
  
                 return "department";
             } // save task
              if(dept.getDepartmentId() == null){
                  
         


       //  Organization orgb = organizationservice.searchByOrganizationId(dept.getOrganization().getOrganizationId());
       //  String organizationId = orgb.getOrganizationId();
          departmentservice.registerDepartment(dept.getOrganization().getOrganizationId(), dept);
        return "redirect:/dept/dept_add";// redirect to above maapping

              }
              //update taske
              else{
                 // dept.setDepartmentId(departmentId);
                  departmentservice.editDepartment(dept);

                  return "redirect:/dept/dept_add";
              }
    }
 
      @ModelAttribute("departmentlists")
    public List<Department> getorganizations(){
        return departmentservice.getDepartmentList();
    }
    /**
     * delete department
     * @return 
     */
     
    
    @RequestMapping(value ="/deleteDepatment")
    public String  deleteDepartment(@RequestParam("departmentId") String departmentId ){
        Department dept =  departmentservice.searchByDepartmentId(departmentId);
        departmentservice.removeDepartment(dept);
     return "redirect:/dept/dept_add";// redirect to above maapping
    }
   
    
    /**
     * get edit page
     * @param departmentId
     * @param m

     * @return 
     */
        @RequestMapping(value  ="/deptEditGet" , method = RequestMethod.GET)
  public String geteditDepartment(@RequestParam("departmentId") String departmentId,Model m){
            List<Organization> orgs = organizationservice.getOrganizationList();
         
      // retrive dept by id
            Department dept = departmentservice.searchByDepartmentId(departmentId);


            m.addAttribute("organizations",orgs);
      // add to model
      m.addAttribute("department", dept);
      
      return "department";  // redirect to deparment page 
  }

    }





























