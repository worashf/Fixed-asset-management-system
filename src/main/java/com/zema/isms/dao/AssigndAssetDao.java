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
public interface AssigndAssetDao {
    public void saveAssignedAsset (AssignedAsset a);

    public void updateAssignedAsset (AssignedAsset a);

    public void deleteAssignedAsset (AssignedAsset a);
    public AssignedAsset getAssignedAssetById(String id);
    public List<AssignedAsset> getAllAssignedAsset();

}
