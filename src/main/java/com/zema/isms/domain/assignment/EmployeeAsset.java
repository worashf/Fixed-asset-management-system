/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain.assignment;

import java.sql.Date;

/**
 *
 * @author ewawuye
 */
public class EmployeeAsset {

    private int EmployeeAssetId;
    private int AssetId;
    private int EmployeeId;
    private Date StartDate;
    private Date EndDate;
    private String Description;

    public int getEmployeeAssetId() {
        return EmployeeAssetId;
    }

    public void setEmployeeAssetId(int EmployeeAssetId) {
        this.EmployeeAssetId = EmployeeAssetId;
    }

    public int getAssetId() {
        return AssetId;
    }

    public void setAssetId(int AssetId) {
        this.AssetId = AssetId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
