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
public class LocationAsset {

    private int LocationAssetId;
    private int AssetId;
    private int LocationId;
    private Date StartDate;
    private Date EndDate;

    public int getLocationAssetId() {
        return LocationAssetId;
    }

    public void setLocationAssetId(int LocationAssetId) {
        this.LocationAssetId = LocationAssetId;
    }

    public int getAssetId() {
        return AssetId;
    }

    public void setAssetId(int AssetId) {
        this.AssetId = AssetId;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int LocationId) {
        this.LocationId = LocationId;
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
    

}
