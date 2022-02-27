/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Catagory;
import com.zema.isms.service.CatagoryService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author ewawuye
 */
@Controller
@RequestMapping("/catagory")
public class CatagoryController {
    
    
        @Autowired //user service interface  
    private CatagoryService catagoryservice;

  
    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
        @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    
 @RequestMapping(value = "/catagory_reg")
    public String catagoryregistrationForm(Model m) {
       Catagory c_cmd = new Catagory ();
       int count = catagoryservice.retriveCatagoryCount();
       m.addAttribute("count", count);
        m.addAttribute("command", c_cmd);
        return "catagory";//JSP
    }
    
 
    @RequestMapping(value = "/catagory_registration")
    public String ctagoryreg(@Valid @ModelAttribute("command") Catagory c,BindingResult result, Model m) {
      if (result.hasErrors()){
          return "catagory";//JSP
      }
      if(c.getCatagoryId()==null) {
          catagoryservice.registerCatagory(c);
          return "redirect:/catagory/catagory_reg?act=cat_reg";// maping
      }
      else {
          catagoryservice.editCatagory(c);
          return "redirect:/catagory/catagory_reg?act=cat_reg";// maping
      }
     
    }
    @RequestMapping(value = "/deleteCtagory")
    public String deletecatagory(@RequestParam("catagoryId") String catagoryId){
  
     catagoryservice.removeCatagory(catagoryId);
        
        return "redirect:/catagory/catagory_reg?act=cat_reg";// maping";
    }
    @ModelAttribute("catagoryList")
   public List<Catagory> getCatagoryLits(){
       return catagoryservice.getCatagoryList() ;
   }
   @RequestMapping(value = "/editCatagory")
    public String editCatagory(@RequestParam("catagoryId") String catagoryId, Model m){
       Catagory cat = catagoryservice.searchByCatagoryId(catagoryId);
       m.addAttribute("command",cat);
        return "catagory";//JSP
    }

 
}
    

