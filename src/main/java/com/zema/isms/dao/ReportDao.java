/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.AssignedAsset;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface ReportDao {
   public List<AssignedAsset> getAssignedAssetByDepartment(String departmentId);
    public List<AssignedAsset> getAssignedAssetByCategory(String catagoryId);
        public List<AssignedAsset> getAssignedAssetByDepartmentAndCategory(String categoryId, String departmentId);
}
