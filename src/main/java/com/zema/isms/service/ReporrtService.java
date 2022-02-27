/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ewawuye
 */
public interface ReporrtService {
    public List<Map<String, Object>> report(int pageNo, int resultperpage);
     public List<Map<String, Object>> generateReportByDepartment(String departmentId);
    public List<Map<String, Object>> generateReportByCategory(String catagoryId);
     public List<Map<String, Object>> generateAssetInStoreReportByCategory(String catagoryId);
       public List<Map<String, Object>> generateAssignedAssetReportByDepartmentAndCategory(String categoryId, String departmentId);
}
