/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.statusDao;

import com.zema.isms.domain.status.AssetMaintenanceStatus;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface AssetMaintenanceStatusDao {
      public void saveAssetMaintenanceStatus (AssetMaintenanceStatus ams);

    public void updateAssetMaintenanceStatus (AssetMaintenanceStatus ams);

    public void deleteAssetMaintenanceStatus (AssetMaintenanceStatus ams);

    public void deleteAssetMaintenanceStatus (Integer MaintenanceStatusId);

    public AssetMaintenanceStatus    findByMaintenanceStatusId(Integer MaintenanceStatusId);

    public List<AssetMaintenanceStatus> findAllAssetMaintenanceStatus ();
    
    public List<AssetMaintenanceStatus> findByProperty(String propName, Object propValue);
}
