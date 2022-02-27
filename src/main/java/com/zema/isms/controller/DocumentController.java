/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Document;
import com.zema.isms.domain.FileBucket;

import com.zema.isms.service.DocumentService;
import com.zema.isms.service.WarrantyService;
import com.zema.isms.validator.FileValidator;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author ewawuye
 */
@Controller
@RequestMapping("/document")
public class DocumentController 
{
    @Autowired
    private WarrantyService warservice;
     @Autowired
    private DocumentService docservice;
      @Autowired
    private FileValidator fileValidator;
      @InitBinder("fileBucket")
      protected  void initBinder(WebDataBinder dataBinder){
          dataBinder.setValidator(fileValidator);
      }
      @RequestMapping(value = "/add-documetpage", method = RequestMethod.GET)
      public String getAddDocumentPage(ModelMap m,@RequestParam(value ="warrantyId", required = false) String warrantyId){
          FileBucket fileBucket =new  FileBucket();
          m.addAttribute("fileBucket", fileBucket);
          m.addAttribute("warrantyId", warrantyId);
          
         return "add-document";
      }
     @RequestMapping(value = "/save-document", method = RequestMethod.POST)
   public String uploadDocument(@RequestParam("warrantyId")String warrantyId,@Valid FileBucket fileBucket,BindingResult result,
           ModelMap m)  throws IOException{
           if(result.hasErrors()){
               //Warranty warranty = warservice.searchBywarrantyId(warrantyId);
              // m.addAttribute("warranty", warranty);
             //  List<Document> documents = docservice.searchDocByWarrantyId(warrantyId);
              // m.addAttribute("documents", documents);
               return "add-document";
           }
           else{
               docservice.addDocumenet(fileBucket, warrantyId);
              return "assetWarranty";// "redirect:/add-document-"+warrantyId;  to add many document to  warranty
           }
   }
@RequestMapping(value = "/downLoadDocument")
  public  void   downloadDocument(@RequestParam("docId")String docId,ModelMap m,HttpServletRequest request, HttpServletResponse response) throws IOException{
     Document doc =docservice.searchByDocumentId(docId);
     response.setContentType(doc.getType());
     response.setContentLength(doc.getContent().length);
     // to download
   //  response.setHeader("Content-Disposition","attachment;filename=\""+doc.getName()+"\"");
   // view in browser
   response.setHeader("Content-Disposition","inline;filename=\""+doc.getName()+"\"");
     FileCopyUtils.copy(doc.getContent(), response.getOutputStream());
     // flushes output stream
  response.getOutputStream().flush();
     
     
     
     
      
    
  }
public  String  deleteWarrantyDoc(@RequestParam("docId")String docId){
    docservice.removeDocById(docId);
    return null;
}

    
}
