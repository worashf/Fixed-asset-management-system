/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.dao.UserDao;
import com.zema.isms.domain.Employee;
import com.zema.isms.domain.SystemRole;
import com.zema.isms.domain.User;
import com.zema.isms.dto.UserDto;

import com.zema.isms.service.EmployeeService;

import com.zema.isms.service.RoleService;
import com.zema.isms.service.UserService;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ewawuye
 */
@Controller
 @RequestMapping(value = "/security")
public class SecurityControler {
    @Autowired
     private RoleService  roleservice;
        @Autowired
    private  UserService userservice;
         @Autowired
    private  EmployeeService empservice;
        @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping(value = "/getSecutity", method = RequestMethod.GET)
    public ModelAndView getSecurityPage(){
         ModelAndView mv = new ModelAndView("security");
         return mv;
    }
        @RequestMapping(value = "/role_page", method = RequestMethod.GET)
    public ModelAndView getRolePage(){
         ModelAndView mv = new ModelAndView("manageRole");
         SystemRole sr =new  SystemRole();
         List<SystemRole>  roleslist = roleservice.getSystemRoleList();
         mv.addObject("command", sr);
          mv.addObject("roleslist", roleslist);
         return mv;
    }
        @RequestMapping(value = "/user_page", method = RequestMethod.GET)
    public ModelAndView getUserPage(@RequestParam(name = "rolesId",required = false)String[] rolesId){
         ModelAndView mv = new ModelAndView("manageuser");
        
         
         List<SystemRole> systemRoleList = roleservice.getSystemRoleList();
         
         UserDto u = new UserDto();
         mv.addObject("roleList",systemRoleList);
         mv.addObject("user", u);
         mv.addObject("rolesId", rolesId);
         return mv;
    }
         @RequestMapping(value = "/role_reg", method = RequestMethod.POST)
    public String postRoleToDb(@ModelAttribute("command")  SystemRole sr){
        
          roleservice.registerSystemRole(sr);
            return "redirect:/security/role_page";
    }
         @RequestMapping(value = "/user_with_emp", method = RequestMethod.GET)
    public ModelAndView getUserPageWithEmp(@RequestParam(name = "employeeId",required = false)String  employeeId){
         ModelAndView mv = new ModelAndView("manageuser");
        
         
         List<SystemRole> systemRoleList = roleservice.getSystemRoleList();
         Employee emp = empservice.searchByEmployeeId(employeeId);
         
         UserDto u = new UserDto();
         mv.addObject("roleList",systemRoleList);
         mv.addObject("user", u);
            mv.addObject("firstName", emp.getFirstName());
               mv.addObject("middleName", emp.getMiddleName());
                  mv.addObject("lastName", emp.getLastName());
         mv.addObject("employeeId", employeeId);
         return mv;
    }
     @RequestMapping(value = "/user_reg", method = RequestMethod.POST)
    public String  registerUser(@Valid  @ModelAttribute("user")  UserDto user ,BindingResult result, @RequestParam( value = "employeeId",required = false) String employeeId){    
        
        if(result.hasErrors()){
            return "manageuser";
        }
        if(employeeId != null){
             userservice.registerUserWithEmp(user,employeeId);
        }
        else{
           userservice.registerUser(user);
        }
         return "redirect:/security/user_page";
    }
 @RequestMapping(value = "/deleteSytemRole")
    public String deleteSytemRole(@RequestParam("roleId") String roleId){
     SystemRole sr = roleservice.searchBySystemRoleId(roleId);
     roleservice.removeSystemRole(sr);
        
        return "redirect:/security/role_page";
    }
  @RequestMapping(value = "/user_manage",method = RequestMethod.GET)
    public  ModelAndView getSytemRole(){
        ModelAndView  mv = new  ModelAndView("manageusers");
        List<User> users =  userservice.getUserList();
        mv.addObject("userList", users);
        
        return mv;
    }
 
  @RequestMapping(value = "/disable_user")
    public String getDisableUser(@RequestParam("userId") String userId){
     User u = userservice.searchByUserId(userId);
      u.setEnable(false);
     userservice.editUser(u);
        
        return "redirect:/security/user_manage";
    }
   @RequestMapping(value = "/enable_user")
    public String getEnableUser(@RequestParam("userId") String userId){
     User u = userservice.searchByUserId(userId);
       u.setEnable(true);
        userservice.editUser(u);
        return "redirect:/security/user_manage";
    }
     @RequestMapping(value = "/search_emp", method = RequestMethod.GET)
    public ModelAndView Searchemployee(@RequestParam(name = "firstName",required = false)String firstName,@RequestParam(name = "middleName",required = false)String middleName,@RequestParam(name = "lastName",required = false)String lastName){
         ModelAndView mv = new ModelAndView("manageuser");
          List<Employee> empList = null;
         if(firstName !=null){
            empList = empservice.getEmployeeByFirstName(firstName);
         }
           if(middleName !=null){
               empList = empservice.getEmployeeByMiddleName(middleName);
           }
         if(lastName !=null){
               empList = empservice.getEmployeeByLastName(lastName);
           }
        
        
           List<SystemRole> systemRoleList = roleservice.getSystemRoleList();
         UserDto u = new UserDto();
         mv.addObject("empList",empList);
         mv.addObject("user", u);
           mv.addObject("roleList",systemRoleList);
       
         return mv;
    }
    
    
 }
