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
public class StoreAsset {

    private int StroreAssetId;
    private int AssetId;
    private int StoreId;
    private Date StartDate;
    private Date EndDate;

    public int getStroreAssetId() {
        return StroreAssetId;
    }

    public void setStroreAssetId(int StroreAssetId) {
        this.StroreAssetId = StroreAssetId;
    }

    public int getAssetId() {
        return AssetId;
    }

    public void setAssetId(int AssetId) {
        this.AssetId = AssetId;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int StoreId) {
        this.StoreId = StoreId;
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
    private String Description;

}
