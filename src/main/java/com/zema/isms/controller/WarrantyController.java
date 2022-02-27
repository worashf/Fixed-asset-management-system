/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.Document;
import com.zema.isms.domain.waranty.Warranty;
import com.zema.isms.service.AssetService;
import com.zema.isms.service.WarrantyService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author ewawuye
 */
@Controller
@RequestMapping("/warranty")
public class WarrantyController {
  
  @Autowired
 private WarrantyService warrantyService;
  @Autowired
  private AssetService assetservice;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
 @RequestMapping(value = "/warranty_page", method = RequestMethod.GET)
  public String getWarrantyPage(Model m){
      
   Warranty warranty = new Warranty();
  
   m.addAttribute("warranty", warranty);
    return "warranty";
            }
  
  @RequestMapping(value="/add_warranty",method = RequestMethod.GET)
  public String  getwarratywithAsset(@RequestParam("assetId") String assetId,Model m){
      m.addAttribute("assetId", assetId);
      m.addAttribute("warranty", new Warranty());
      return "warranty";
  }
  @RequestMapping(value = "/warranty", method = RequestMethod.POST)
  public String postWarranty(@RequestParam(value="assetId",required = false) String assetId,@Valid @ModelAttribute("warranty") Warranty warranty,BindingResult result,Model m)
  {
      if (result.hasErrors()) {
          return "warranty";
      }
    
      if(assetId!=null){
            Asset asset = assetservice.searchByAssetId(assetId);
      String assetCode = asset.getAssetCode();
      Asset asset1 = assetservice.searchAsstWithWarranty(assetCode);
      Warranty war = asset1.getWarranty();
          if(war==null){
          warrantyService.registerWarranty(assetId, warranty);
          return "redirect:/warranty/warranty_page?act=warranty_reg";
          }
          else{
            
          m.addAttribute("message"," this asset have already warranty ");
          return "warranty";  
          }
      }else {

          m.addAttribute("message","asset id is not null");
          return "warranty";

      }
      

  }
  // ---  search asset to add warranty --//
       @RequestMapping(value = "/asset_search", method = RequestMethod.GET )
    public String contactSearch(Model m, @RequestParam("freeText") String freeText) {
      
        Warranty warranty = new Warranty();
       m.addAttribute("warranty", warranty);
       Asset  asset =assetservice.searchByAssetCode(freeText);
       if (asset==null){
             m.addAttribute("no_asset", "no such asset with "+ "\t \t"+freeText);
       }
      
        
        m.addAttribute("asset", asset );
        //String assetId = asset.getAssetId();
        //m.addAttribute("assetId", assetId );
        return "warranty";
    }
    //-- asset warranty page --//
    @RequestMapping(value = "/assetWarrantyPage",method = RequestMethod.GET)
    public String getassetWarrantyPage(){
        return "assetWarranty";
    }
    // --- search asset by code with warrany to with waranty information --//
    @RequestMapping(value = "/sssetWithWarranty", method = RequestMethod.GET)
    public String getAssetWithWrranty(@RequestParam("assetCode")String assetCode,Model m){
        Asset asset = assetservice.searchAsstWithWarranty(assetCode);
        if(asset == null){
                  m.addAttribute("message", "no asset  found with this  " +"\t \t" + assetCode);
        }
        else{
        Warranty warranty = asset.getWarranty();
        m.addAttribute("assetWarranty", asset);
        m.addAttribute("warranty", warranty);
        }
        return "assetWarranty";
    }
    @RequestMapping(value = { "/warrantyAtachment" }, method = RequestMethod.GET)
    public void getwarrantyAttachment(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam("warrantyId") String warrantyId) throws IOException {
        
            Warranty war=  warrantyService.searchBywarrantyId(warrantyId);
        
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
           //response.getOutputStream().write(war.getAtachment());
        
        response.getOutputStream().close();
    }
     // --- search asset by code with warrany to with waranty and documentinformation --//
    @RequestMapping(value = "/sssetWithWarrantyDocument", method = RequestMethod.POST)
    public String getAssetWithWrrantyDocument(@RequestParam("assetCode")String assetCode,Model m){
        Asset asset = warrantyService.searchAssetAdnwarrantyDocument(assetCode);
        if(asset == null){
                  m.addAttribute("message", "no asset  found with this  " +"\t \t" + assetCode);
        }
        else{
        Warranty warranty = asset.getWarranty();
       List<Document> doc =  warranty.getDocuments();
        m.addAttribute("assetWarranty", asset);
        m.addAttribute("warranty", warranty);
         m.addAttribute("documents", doc);
        }
        return "assetWarranty";
    }
    
}
