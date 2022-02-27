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
public class DepartmentAsset {

    private int DepartmentAssetId;
    private int AssetId;
    private int DepartmentId;
    private Date StartDate;
    private Date EndDate;
    private String Description;

    public int getDepartmentAssetId() {
        return DepartmentAssetId;
    }

    public void setDepartmentAssetId(int DepartmentAssetId) {
        this.DepartmentAssetId = DepartmentAssetId;
    }

    public int getAssetId() {
        return AssetId;
    }

    public void setAssetId(int AssetId) {
        this.AssetId = AssetId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
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
