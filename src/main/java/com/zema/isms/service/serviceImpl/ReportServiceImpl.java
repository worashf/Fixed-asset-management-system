/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.AssetDao;
import com.zema.isms.dao.ReportDao;
import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssignedAsset;
import com.zema.isms.domain.Catagory;
import com.zema.isms.domain.Department;
import com.zema.isms.domain.Employee;
import com.zema.isms.service.ReporrtService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Service
public class ReportServiceImpl implements ReporrtService{
    @Autowired
 private  AssetDao assetdao;
        @Autowired
private ReportDao reportdao;
    @Override
    @Transactional
    public List<Map<String, Object>> report(int pageNo, int resultperpage) {
        Asset asset = null;
        Catagory cat = null;
        Employee emp = null;
        Department dept = null;
        
       List<Map<String, Object>> result = new ArrayList<>();
      List<AssignedAsset> assignedAssetList = assetdao.getAllAssignedAssets(pageNo, resultperpage);
  
		for (AssignedAsset assignedAsset : assignedAssetList) {
			Map<String, Object> item = new HashMap<>();
                       asset =assignedAsset.getAsset();
                       cat = asset.getCatagory();
                       emp =assignedAsset.getEmployee();
                       dept = emp.getDepartment();
			item.put("FirstName", emp.getFirstName());
			item.put("MiddleName", emp.getMiddleName());
			item.put("EmployeeCode",emp.getCode());
			//item.put("department", dept.getName());
			item.put("AssetCode", asset.getAssetCode());
                        item.put("CategoryName", cat.getCatagoryName());
                       // item.put("Quantity", assignedAsset.getQuantity());
                       // item.put("AssignedDate", assignedAsset.getAssignDate());
                        result.add(item);
		}
		return result;
    }
    @Transactional
    @Override
    public List<Map<String, Object>> generateReportByDepartment(String departmentId) {
       Asset asset = null;
        Catagory cat = null;
        Employee emp = null;
        Department dept = null;
        int count = assetdao.getAssignedAssetByDepartment(departmentId);
       List<Map<String, Object>> result = new ArrayList<>();
      List<AssignedAsset> assignedAssetList = reportdao.getAssignedAssetByDepartment(departmentId);
  
		for (AssignedAsset assignedAsset : assignedAssetList) {
			Map<String, Object> item = new HashMap<>();
                       asset =assignedAsset.getAsset();
                       cat = asset.getCatagory();
                       emp =assignedAsset.getEmployee();
                       dept = emp.getDepartment();
			item.put("FirstName", emp.getFirstName());
			item.put("MiddleName", emp.getMiddleName());
			item.put("EmployeeCode",emp.getCode());
			item.put("DepartmentName", dept.getName());
			item.put("AssetCode", asset.getAssetCode());
                        item.put("CategoryName", cat.getCatagoryName());
                       // item.put("Quantity", assignedAsset.getQuantity());
                       // item.put("AssignedDate", assignedAsset.getAssignDate());
                         item.put("count", count);
                        result.add(item);
		}
		return result;
    }
    @Transactional
    @Override
    public List<Map<String, Object>> generateReportByCategory(String catagoryId) {
     Asset asset = null;
        Catagory cat = null;
        Employee emp = null;
        Department dept = null;
         int count = assetdao.getAssignedAssetByCategory(catagoryId);
       List<Map<String, Object>> result = new ArrayList<>();
      List<AssignedAsset> assignedAssetList = reportdao.getAssignedAssetByCategory(catagoryId);
  
		for (AssignedAsset assignedAsset : assignedAssetList) {
			Map<String, Object> item = new HashMap<>();
                       asset =assignedAsset.getAsset();
                       cat = asset.getCatagory();
                       emp =assignedAsset.getEmployee();
                       dept = emp.getDepartment();
			item.put("FirstName", emp.getFirstName());
			item.put("MName", emp.getMiddleName());
			item.put("ECode",emp.getCode());
			//item.put("department", dept.getName());
			item.put("AssetCode", asset.getAssetCode());
                        item.put("CName", cat.getCatagoryName());
                        item.put("Quantity", assignedAsset.getQuantity());
                        item.put("AssignDate", assignedAsset.getAssignDate());
                        //item.put("Price", asset.getPrice());
                        result.add(item);
		}
		return result;
    }
 @Transactional
    @Override
    public List<Map<String, Object>> generateAssetInStoreReportByCategory(String catagoryId) {
  
        Catagory cat ;
        
        float price;
        String brand ;
        
       List<Map<String, Object>> result = new ArrayList<>();
      List<Asset> assetList = assetdao.findAsssetByCategory(catagoryId,false);
  
		for (Asset asset : assetList) {
			Map<String, Object> item = new HashMap<>();
                   
                       cat = asset.getCatagory();
                       price = asset.getPrice();
                       brand = asset.getBrand();
                    
	          item.put("price", price);
                    item.put("brand", brand);
                    item.put("categoryName", cat.getCatagoryName());
                    item.put("assetCode", asset.getAssetCode());
                    item.put("status", asset.getQualityCondition());
        
                       
                        result.add(item);
		}
		return result;
    }

    @Override
    public List<Map<String, Object>> generateAssignedAssetReportByDepartmentAndCategory(String categoryId, String departmentId) {
            Asset asset = null;
        Catagory cat = null;
        Employee emp = null;
        Department dept = null;
         int count = assetdao.getAssignedAssetByDepartmentAndCategory(categoryId, departmentId);
        
       List<Map<String, Object>> result = new ArrayList<>();
      List<AssignedAsset> assignedAssetList = reportdao.getAssignedAssetByDepartmentAndCategory(categoryId, departmentId);
  
		for (AssignedAsset assignedAsset : assignedAssetList) {
			Map<String, Object> item = new HashMap<>();
                       asset =assignedAsset.getAsset();
                       cat = asset.getCatagory();
                       emp =assignedAsset.getEmployee();
                       dept = emp.getDepartment();
			item.put("FirstName", emp.getFirstName());
			item.put("MName", emp.getMiddleName());
			item.put("ECode",emp.getCode());
			//item.put("department", dept.getName());
			item.put("AssetCode", asset.getAssetCode());
                        item.put("CName", cat.getCatagoryName());
                        item.put("Quantity", assignedAsset.getQuantity());
                        item.put("AssignDate", assignedAsset.getAssignDate());
                        //item.put("Price", asset.getPrice());
                        result.add(item);
		}
		return result;

    }
}
