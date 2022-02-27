/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Organization;
import com.zema.isms.dto.OrganizationDto;
import com.zema.isms.service.DepartmentService;
import com.zema.isms.service.OrganizationService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DuplicateKeyException;
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
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired 
    private OrganizationService organizationservice;

  @Autowired
    private DepartmentService departmentservice;
        @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
@RequestMapping(value = "/organization_reg", method=RequestMethod.GET)
    public String orgregistrationForm(Model m) {
      Organization org = new Organization ();
       List<Organization>  organizationlist = organizationservice.getOrganizationList();
       m.addAttribute("organizationList",organizationlist );
        m.addAttribute("orgcommand", org);
        return "manageorganization";//JSP
    }


    @RequestMapping(value = "/org_registration", method = RequestMethod.POST)
    public String organizationreg(@Valid @ModelAttribute("orgcommand") Organization org ,BindingResult result, Model m,HttpSession session) {
       
    if(result.hasErrors()){
        return "manageorganization";
    }
    if(org.getOrganizationId()==null){
       organizationservice.registerOrganization(org);

           return "redirect:organization_reg?act=org_reg";//JSP 
    }
    else{
        organizationservice.editOrganization(org);
         return "redirect:organization_reg?act=org_update";//JSP 
    }   
       
      
        
    }
  
    @RequestMapping(value= "/deleteOrganization")
    public String  deleteOrganization(@RequestParam("organizationId") String organizationId){
        
        Organization org =  organizationservice.searchByOrganizationId(organizationId);
        
        organizationservice.removeOrganization(org);
        return "redirect:/organization/organization_reg";
    }
 
    @RequestMapping(value  ="orgEditGet" , method = RequestMethod.GET)
  public String geteditOrganization(@RequestParam("organizationId") String organizationId,Model m,HttpSession session){
      // set org id in session
      session.setAttribute("orgId",organizationId);
      // retrive org by id
              Organization org =  organizationservice.searchByOrganizationId(organizationId);
      // add to model
      m.addAttribute("orgcommand", org);
      
      return "manageorganization"; 
  }
    
}
