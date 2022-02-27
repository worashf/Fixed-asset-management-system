/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Catagory;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface CatagoryService {
     
   /**
    * 
    * @param c 
    */
   public  void registerCatagory(Catagory c);
   /**
    * 
    * @param c 
    */
    public void editCatagory(Catagory c);
  /**
   * 
   * @param catagoryId 
   */
    public void  removeCatagory(String  catagoryId );
   /**
    * 
    * @param catagoryId
    * @return 
    */
    public Catagory searchByCatagoryId(String  catagoryId);
   
    public List<Catagory> getCatagoryList();
    public Catagory searchCategoryByName(String  name);
    public int retriveCatagoryCount();
      
}
