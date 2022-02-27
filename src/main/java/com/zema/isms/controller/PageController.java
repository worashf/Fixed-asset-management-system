/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.service.AssetService;
import com.zema.isms.service.CatagoryService;
import com.zema.isms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ewawuye
 */
@Controller
public class PageController {
 @Autowired
 private AssetService assetService;
       @Autowired
    private DepartmentService departmentservice;
          @Autowired //user service interface  
    private CatagoryService catagoryservice;
      @RequestMapping(value = "/")
    public String home(Model m) {
    int  assetInStoreCount = assetService.getAssetCountInStore();
    int assignedAssetCount = assetService.searchAssignAssetCount();
     m.addAttribute("assetInStoreCount",assetInStoreCount);
     m.addAttribute("assignedAssetCount",assignedAssetCount);
      int countcat = catagoryservice.retriveCatagoryCount();
                int countdept = departmentservice.retriveDepartmentCount();
     m.addAttribute("countdept",countdept);
         m.addAttribute("countcat", countcat);
        return "adminmaster";//JSP
    }

    @RequestMapping("/department")
    public String departmentget() {
        return "department";
    }
   @RequestMapping("/catagory")
    public String ctagoryget() {
        return "catagory";
    }
    @RequestMapping("/organization")
    public String organizationget() {
        return "manageorganization";
    }
    @RequestMapping(value = {"/home",  "/index", "/dashboard"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("adminmaster");
        mv.addObject("title", "AdminHome");
        mv.addObject("AdminClickDashboard", true);
        int  assetInStoreCount = assetService.getAssetCountInStore();
        int assignedAssetCount = assetService.searchAssignAssetCount();
        mv.addObject("assetInStoreCount",assetInStoreCount);
        mv.addObject("assignedAssetCount",assignedAssetCount);
            int countcat = catagoryservice.retriveCatagoryCount();
                int countdept = departmentservice.retriveDepartmentCount();
        mv.addObject("countdept",countdept);
        mv.addObject("countcat", countcat);
        // personal assset count 
        return mv;
    }
     @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
     public ModelAndView loginPage(){
       ModelAndView mv = new ModelAndView("loginPage");
  
        return mv;
     }
     
    	
  @RequestMapping(value = "/access-denied",method = RequestMethod.GET)
	public String accessDenied(){
		return "access-denied";
	}
}
