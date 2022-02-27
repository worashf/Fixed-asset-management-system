/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.waranty.Warranty;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface WarrantyDao {
     public void saveWarranty (Warranty w);

    public void updateWarranty (Warranty w);

    public void deleteWarranty (Warranty w);

    public void deleteWarranty (String warrantyId);

    public Warranty     findByWarrantyId(String warrantyId);

    public List<Warranty> findAllWarranty ();
    
    public List<Warranty> findByProperty(String propName, Object propValue);
    public Asset  getAssetAdnwarrantyDocument(String assetCode);
    
}
