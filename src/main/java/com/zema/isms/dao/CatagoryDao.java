/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.Catagory;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface CatagoryDao {
     public void saveCatagory (Catagory c);

    public void updateCatagory (Catagory c);

    public void deleteCatagory (Catagory c);

    public void deleteCatagory (String CatagoryId);

    public Catagory    findByCatagoryId(String CatagoryId);

    public List<Catagory > findAllCatagory ();
    public Catagory getCatagoryByName(String catagoryName);
    
    public List<Catagory > findByProperty(String propName, Object propValue);
    public int getCategoryCount();
}
