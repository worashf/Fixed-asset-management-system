/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain.status;

/**
 *
 * @author ewawuye
 */
public class AssetMaintenanceStatus {
    private int MaintenanceStatusId;
    private String MaintenanceStatusValue;
    private String Description;

    public int getMaintenanceStatusId() {
        return MaintenanceStatusId;
    }

    public void setMaintenanceStatusId(int MaintenanceStatusId) {
        this.MaintenanceStatusId = MaintenanceStatusId;
    }

    public String getMaintenanceStatusValue() {
        return MaintenanceStatusValue;
    }

    public void setMaintenanceStatusValue(String MaintenanceStatusValue) {
        this.MaintenanceStatusValue = MaintenanceStatusValue;
    }

   
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
