/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.AssetDao;
import com.zema.isms.dao.AssigndAssetDao;

import com.zema.isms.dao.CatagoryDao;
import com.zema.isms.dao.EmployeeDao;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssignedAsset;

import com.zema.isms.domain.Catagory;
import com.zema.isms.domain.Employee;
import com.zema.isms.service.AssetService;
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

    public class AssetServiceImpl implements AssetService{
    @Autowired
 private  AssetDao assetdao;
  
         @Autowired
  private CatagoryDao catagorydao;
         
        @Autowired
   private AssigndAssetDao assigndAssetDao;
         @Autowired
   private EmployeeDao employeeDao;
    @Transactional
    @Override
   public void registerAsset(String categoryId,Asset a) {
     Catagory cat = catagorydao.findByCatagoryId(categoryId);
     a.setAssigned(false);
     a.setCatagory(cat);
     cat.getAsset().add(a);
     
     assetdao.saveAsset(a);
    }

    
   
   @Transactional
   @Override
    public void editAsset(Asset a) {
       assetdao.updateAsset(a);
    }
@Transactional
    @Override
    public void removeAsset(Asset asset) {
        assetdao.deleteAsset(asset);
    }
@Transactional
    @Override
    public Asset searchByAssetId(String assetId) {
       
      Asset asset = null;
        try{
         asset = assetdao.findByAssetId(assetId);
        }
        catch(NoResultException ex){
            
        }
       return asset;
    }
    
@Transactional
    @Override
    public List<Asset> getAssetListInStore(int pageNo, int resultperpage,boolean assinged) {
      return   assetdao.findAllAssetInStore(pageNo,resultperpage,assinged);
    }
@Transactional
    @Override
    public Asset searchByAssetCode(String assetCode) {
   
           Asset asset = null;
        try{
            asset =assetdao.findByAssetCode(assetCode);
        }
        catch(NoResultException ex){
            
        }
       return asset;
    }

   
    @Transactional
    @Override
    public List<Asset> searchAssetByAssetType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
@Transactional
    @Override
    public List<Asset> searchByPropNmae(String propName) {
     return  assetdao.findByProperty(propName);
    }
@Transactional
    @Override
    public void addAssetToEmp(String assetId, String employeeId) {
        assetdao.AssignAssetToEmployee(assetId,employeeId);
    }
@Transactional
    @Override
    public List<Asset> searchEmployeeAsset(String employeeId) {
         return assetdao.findEmployeeAsset(employeeId);
    }
@Transactional
    @Override
    public Asset searchAsstWithWarranty(String assetCode) {
        Asset asset = null;
        try{
            asset = assetdao.findAssetWithWarranty(assetCode);
        }
        catch(NoResultException ex){
            
        }
       return asset;
    }
    @Transactional
    @Override
    public boolean isAssetCodeInDb(String code) {
      boolean assetCodeInDb= true;
      if(assetdao.findByAssetCode(code)==null){
          assetCodeInDb= false;
          
      }
      return assetCodeInDb;
    }
 @Transactional
    @Override
    public void assignAssetToemployee(AssignedAsset ae, String employeeId, String assetId) {
        Asset asset = assetdao.findByAssetId(assetId);
        Employee emp = employeeDao.findByEmployeeId(employeeId);
         asset.setAssigned(true);
         asset.setAssignedAsset(ae);
         ae.setAsset(asset);
       
        ae.setEmployee(emp);
       
        emp.getAssignedAsset().add(ae);
      
      assigndAssetDao.saveAssignedAsset(ae);
    }
// not used curren
    @Transactional
    @Override
    public boolean isAssetAssigned(String assetId) {
        boolean isAssigned =false;
    if(assigndAssetDao.getAssignedAssetById(assetId)==null){
        isAssigned = true;
    }
    
    return isAssigned;
    
    }
@Transactional
    @Override
    public List<AssignedAsset> retriveAllAssigedAsset(int pageNo, int resultperpage) {
    return assetdao.getAllAssignedAssets( pageNo,  resultperpage);
    }
@Transactional
    @Override
    public List<AssignedAsset> retriveAllAssignedAssetByEmployeeCode(String employeeId) {
       return assetdao.getAllAssignedAssetToEmployee(employeeId);
    }
// retrive assign with asset and return assets
    @Transactional
    @Override
    public void returnAsset(String assignedId) {
       AssignedAsset assigned =  assetdao.getAssignedAssetWithAsset(assignedId);
       Asset asset = assigned.getAsset();
       asset.setAssigned(false);
       assigndAssetDao.deleteAssignedAsset(assigned);
    }
@Transactional
    @Override
    public int searchAssignedAssetCountByEmployee(String employeeId) {
  
     int count =assetdao.getAssignedAssetCountByEmployee(employeeId);
     return count;
    }


@Transactional
    @Override
    public List<AssignedAsset> retriveAllAssignedAssetByDepartment(String deptId,int pageNo, int resultperpage) {
         List<AssignedAsset> assignedAsset = null;
         try{
          assignedAsset   =assetdao.findAssignedAssetByDepartment(deptId, pageNo, resultperpage);
         }
         catch(NoResultException ex){
             
         }
      return      assignedAsset;
    }
  @Transactional
    @Override
    public List<AssignedAsset> retriveAllAssignedAssetByCatagory(String catagoryId,int pageNo, int resultperpage) {
        List<AssignedAsset>      assignedAsset = null;
         try{
          assignedAsset  = assetdao.findAssignedAssetByCategory(catagoryId, pageNo,  resultperpage);

         }
         catch(NoResultException ex){
             
         }
      return      assignedAsset;
    }
  @Transactional
    @Override
    public List<AssignedAsset> retriveAllAssignedAssetByCatagoryAndDEpartment(String categoryId, String departmentId,int pageNo, int resultperpage) {
      
         List<AssignedAsset>   assignedAsset = null;
         try{
          assignedAsset  =assetdao.findAssignedAssetByDepartmentAndCategory(categoryId, departmentId, pageNo,  resultperpage);

         }
         catch(NoResultException ex){
             
         }
      return      assignedAsset;
    }
  @Transactional
    @Override
    public int searchAssignedAssetCountByCatagory(String catagoryId) {
    int count = assetdao.getAssignedAssetByCategory(catagoryId);
    return count;
    }
  @Transactional
    @Override
    public int searchAssignedAssetCountByDepartment(String departmentId) {
   int count = assetdao.getAssignedAssetByDepartment(departmentId);
   return count;
    }
   @Transactional
    @Override
    public int searchAssignedAssetCountByDepartmentAndcatagoryId(String departmentId, String catagoryId) {
       int count = assetdao.getAssignedAssetByDepartmentAndCategory(catagoryId, departmentId);
       return count;
    }
  @Transactional
    @Override
    public int searchAssignedAssetPageCountByCatagory(String catagoryId, int resultsPerPage) {
      int AssignedAssetCount = 0;
		int searchAssignedAssetPagesCount = 1;
		AssignedAssetCount = this.searchAssignedAssetCountByCatagory(catagoryId);
		searchAssignedAssetPagesCount= (int) Math.floorDiv(AssignedAssetCount, resultsPerPage) + 1;
		
		return searchAssignedAssetPagesCount;
    }

      @Transactional
    @Override
    public int searchAssignedAssetPageCountByDepartment(String departmentId, int resultperpage) {
          int AssignedAssetCount = 0;
		int searchAssignedAssetPagesCount = 1;
		AssignedAssetCount = this.searchAssignedAssetCountByDepartment(departmentId);
		searchAssignedAssetPagesCount= (int) Math.floorDiv(AssignedAssetCount, resultperpage) + 1;
		
		return searchAssignedAssetPagesCount;
    }
  @Transactional
    @Override
    public int searchAssignedAssetPageCountByDepartmentAndcatagoryId(String departmentId, String catagoryId, int resultpeerpage) {
                int AssignedAssetCount = 0;
	      int searchAssignedAssetPagesCount = 1;
	      AssignedAssetCount = this.searchAssignedAssetCountByDepartmentAndcatagoryId(departmentId, catagoryId);
	      searchAssignedAssetPagesCount= (int) Math.floorDiv(AssignedAssetCount,  resultpeerpage) + 1;
		
		return searchAssignedAssetPagesCount;
    }
 @Transactional
    @Override
    public int searchAssignAssetCount() {
         int count = assetdao.getAssignedAssetcount();
       return count;
    }
  @Transactional
    @Override
    public int searchAssignedAssetPageCount(int resultperpage) {
                    int AssignedAssetCount = 0;
		int searchAssignedAssetPagesCount = 1;
		AssignedAssetCount = this.searchAssignAssetCount();
		searchAssignedAssetPagesCount= (int) Math.floorDiv(AssignedAssetCount,  resultperpage) + 1;
		
		return searchAssignedAssetPagesCount;
    }
    @Transactional
    @Override
    public int getAssetCountInStore() {
        int count = assetdao.getToalAssetInStorecount();
        return count;
    }

    @Transactional
    @Override
    public int AssetInStoreCountByCatagory(String catagoryId) {
        
   int assetCount = assetdao.getToalAssetcountByCategory(catagoryId);
   int assignedAssetCount =assetdao.getAssignedAssetByCategory(catagoryId);
   
   int assetInStore = assetCount - assignedAssetCount;
   return assetInStore;
    }
  @Transactional
    @Override
    public int searctTotalAssetCountByCatagory(String catagoryId) {
      int assetCount = assetdao.getToalAssetcountByCategory(catagoryId);
       return assetCount;
    }
  @Transactional
    @Override
    public int searchAssignAssetCountByEmployee(String employeeId) {
       int count = assetdao.getAssignedAssetCountByEmployee(employeeId);
       return count;
    }
  @Transactional
    @Override
    public int searchAssignedAssetPageCountByEmployee(String employeeId, int resultperpage) {
         int AssignedAssetCount = 0;
		int searchAssignedAssetPagesCount = 1;
		AssignedAssetCount = this.searchAssignAssetCountByEmployee(employeeId);
		searchAssignedAssetPagesCount= (int) Math.floorDiv(AssignedAssetCount,  resultperpage) + 1;
		
		return searchAssignedAssetPagesCount;
    }
    @Transactional
    @Override
    public Asset retriveAssetByAssignedId(String assignedId) {
        Asset asset = null;
        try
        {

           asset = assetdao.getAssetByAssigndId(assignedId);
        }
        catch (NoResultException ex){

        }
        return asset;
    }
   @Transactional
    @Override
    public Asset searchAssetInStoreByAssetCode(String assetCode, boolean assigned) {
      Asset asset =null;
      try{
         asset =assetdao.findAssetInstoreByAssetCode(assetCode, assigned);
      }
      catch(NoResultException ex){
          
      }
      return asset;
    }
   @Transactional
    @Override
    public List<Asset> searchAssetInCatagory(String catagoryId,int pageNo, int resultperpage, boolean assigned) {
    List<Asset> assets =null;
      try{
         assets =assetdao.findAsssetByCategory(catagoryId,pageNo,resultperpage, assigned);
      }
      catch(NoResultException ex){
          
      }
      return assets;
    }
   @Transactional
    @Override
    public int findAssetCountInStore() {
         int assetCount = assetdao.getAssetCounyInStore(false);
       return assetCount;
    }
   @Transactional
    @Override
    public int findAssetCountInStoreByCatagory(String categoryId) {
        int assetCount = assetdao.getAssetCountInStoreByCategory(categoryId, false);
       return assetCount;
    }
   @Transactional
    @Override
    public int findAssetInStorePageCount(int resultperpage) {
          int AssetInStoreCount = 0;
		int AssetInStorePagesCount = 1;
		AssetInStoreCount = this.findAssetCountInStore();
		AssetInStorePagesCount= (int) Math.floorDiv(AssetInStoreCount,  resultperpage) + 1;
		
		return AssetInStorePagesCount;
    }
   @Transactional
    @Override
    public int findAssetInStorePageCountByCatagory(String categoryId, int resultperpage) {
        int AssetInStoreCount = 0;
		int AssetInStorePagesCount = 1;
		AssetInStoreCount = this.findAssetCountInStoreByCatagory(categoryId);
		AssetInStorePagesCount= (int) Math.floorDiv(AssetInStoreCount,  resultperpage) + 1;
		
		return AssetInStorePagesCount;
    }
    

}
