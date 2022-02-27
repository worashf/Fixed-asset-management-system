/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.AssetDao;
import com.zema.isms.dao.WarrantyDao;
import com.zema.isms.domain.Asset;
import com.zema.isms.domain.waranty.Warranty;
import com.zema.isms.service.WarrantyService;
import javax.persistence.NoResultException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ewawuye
 */
@Service

public class WarrantyServiceImpl  implements WarrantyService{
    @Autowired
 private  AssetDao assetdao;
        @Autowired
 private  WarrantyDao  warrantydao;
    @Override
    @Transactional
    public void registerWarranty(String assetId, Warranty w) {
    
      
      Warranty war = new Warranty(); Asset asset  =  assetdao.findByAssetId(assetId);
     war.setWarrantyId(w.getWarrantyId());
     war.setWarrantyName(w.getWarrantyName());
     war.setStartDate(w.getStartDate());
     war.setEndDate(w.getEndDate());
     war.setDescription(w.getDescription());
     
       
       
     w.setAsset(asset);
     asset.setWarranty(war);
     warrantydao.saveWarranty(w);
       
     
    }

    @Override
    public void editWarranty(Warranty w) {
    
    }

    @Override
    public void removeWarranty(String warrantyId) {
        
    }

    @Override
    @Transactional
    public Warranty searchBywarrantyId(String warrantyId) {
       return   warrantydao.findByWarrantyId(warrantyId);
    }
  @Transactional
    @Override
    public Asset searchAssetAdnwarrantyDocument(String assetCode) {
     Asset asset = null;
     try{
         asset = warrantydao.getAssetAdnwarrantyDocument(assetCode);
     }
     catch(NoResultException ex){
         
     }
     return asset;
    }
    
}
