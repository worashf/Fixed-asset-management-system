/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.waranty.Warranty;


/**
 *
 * @author ewawuye
 */
public interface WarrantyService {
     /**
     * 
     * @param a
     */
   public  void registerWarranty(String assetId,Warranty w);
   /**
    * 
    * @param a
    */
    public void editWarranty(Warranty w);
  /**
   * 
   * @param assetId 
   */
    public void  removeWarranty(String warrantyId );
   /**
    * 
    * @param assetId
    * @return 
    */
    public Warranty searchBywarrantyId(String warrantyId );
    public Asset searchAssetAdnwarrantyDocument(String assetCode);

    
}
