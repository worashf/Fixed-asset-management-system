/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssignedAsset;

import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface AssetService {

    /**
     *
     * @param a
     */
    public void registerAsset(String categoryId, Asset a);

    /**
     *
     * @param a
     */
    public void editAsset(Asset a);

    /**
     *
     * @param assetId
     */
    public void removeAsset(Asset asset);

    /**
     *
     * @param assetId
     * @return
     */
    public Asset searchByAssetId(String assetId);

    public List<Asset> getAssetListInStore(int pageNo, int resultperpage,boolean assinged);

    public Asset searchByAssetCode(String assetCode);
    public Asset searchAssetInStoreByAssetCode(String assetCode,boolean assigned);

    public List<Asset> searchAssetInCatagory(String catagoryId,int pageNo, int resultperpage,boolean assigned);

    public List<Asset> searchAssetByAssetType();

    public List<Asset> searchByPropNmae(String propName);

    /**
     * add assign asset to employee
     *
     * @param assetId
     * @param employeeId
     */
    public void addAssetToEmp(String assetId, String employeeId);

    /**
     * search asset owned to employee
     *
     * @param employeeId
     * @return
     */

    public List<Asset> searchEmployeeAsset(String employeeId);

    public Asset searchAsstWithWarranty(String assetCode);

    public boolean isAssetCodeInDb(String code);

    public void assignAssetToemployee(AssignedAsset a, String employeeId, String assetId);

    public void returnAsset(String assignedId);

    public boolean isAssetAssigned(String assetId);

    public List<AssignedAsset> retriveAllAssigedAsset(int pageNo, int resultperpage);

    public List<AssignedAsset> retriveAllAssignedAssetByEmployeeCode(String employeeId);
    
    // count asset in store
      public int AssetInStoreCountByCatagory(String catagoryId);
     public int searctTotalAssetCountByCatagory(String catagoryId);
    

    //count service
    public int searchAssignedAssetCountByEmployee(String employeeId);
    public int searchAssignedAssetCountByCatagory(String catagoryId);
    public int searchAssignedAssetCountByDepartment(String departmentId);
    public int searchAssignedAssetCountByDepartmentAndcatagoryId(String departmentId, String catagoryId);
    
    // page count for specifi search
    public int searchAssignedAssetPageCountByCatagory(String catagoryId, int resultsPerPage);

    public int searchAssignedAssetPageCountByDepartment(String departmentId, int resultperpage);

    public int searchAssignedAssetPageCountByDepartmentAndcatagoryId(String departmentId, String catagoryId, int resultpeerpage);
    public int searchAssignAssetCount();
    public int searchAssignedAssetPageCount(int resultperpage);
    public int getAssetCountInStore();
   // public List<AssignedAsset> searchAllAssigedAsset(int pageNo, int resultperpage);

    public List<AssignedAsset> retriveAllAssignedAssetByDepartment(String deptId,int pageNo, int resultperpage);

    public List<AssignedAsset> retriveAllAssignedAssetByCatagory(String catagoryId,int pageNo, int resultperpage);

    public List<AssignedAsset> retriveAllAssignedAssetByCatagoryAndDEpartment(String categoryId, String departmentId,int pageNo, int resultperpage);

    public int searchAssignAssetCountByEmployee(String employeeId);
    public int  searchAssignedAssetPageCountByEmployee(String employeeId, int resultperpage);
    public Asset retriveAssetByAssignedId(String assignedId);
    public int findAssetCountInStore();
    public int findAssetCountInStoreByCatagory(String categoryId);
       public int findAssetInStorePageCount(int resultperpage);
    public int findAssetInStorePageCountByCatagory(String categoryId,int resultperpage);
}
