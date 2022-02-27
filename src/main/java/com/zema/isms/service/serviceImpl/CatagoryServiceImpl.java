/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.CatagoryDao;

import com.zema.isms.domain.Catagory;
import com.zema.isms.service.CatagoryService;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Service
public class CatagoryServiceImpl implements CatagoryService{
  @Autowired
  private CatagoryDao catagorydao;
  
    @Override
    @Transactional
    public void registerCatagory(Catagory c) {
       catagorydao.saveCatagory(c);
    }
@Transactional
    @Override
    public void editCatagory(Catagory c) {
       catagorydao.updateCatagory(c);
    }
@Transactional
  @Override
    public void removeCatagory(String catagoryId) {
         catagorydao.deleteCatagory(catagoryId);
    }
@Transactional
  @Override
    public Catagory searchByCatagoryId(String catagoryId) {
         Catagory cat = null;
  try{
      cat =  catagorydao.findByCatagoryId(catagoryId);
  }
  catch(NoResultException ex){
      
  }
  return  cat;
    }
      
    
@Transactional
    @Override
    public List<Catagory> getCatagoryList() {
      return catagorydao.findAllCatagory();
    }
@Transactional
    @Override
    public Catagory searchCategoryByName(String name) {
   Catagory cat = null;
  try{
      cat =  catagorydao.getCatagoryByName(name);
  }
  catch(NoResultException ex){
      cat = null;
  }
  return  cat;
    }
@Transactional
    @Override
    public int retriveCatagoryCount() {
       int count =0;
       try{
         count =catagorydao.getCategoryCount();
       }
       catch(NoResultException ex){
           
       }
       return count;
    }

    
    
}
