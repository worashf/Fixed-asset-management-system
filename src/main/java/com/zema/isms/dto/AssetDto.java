/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dto;

import com.zema.isms.domain.Catagory;
import com.zema.isms.validator.UniqueAssetCode;

import javax.validation.constraints.NotNull;

/**
 *
 * @author ewawuye
 */
public class AssetDto {
    

   
    private String assetId;
  
   // asset serial  number and it can take null value
    private String assetName;

    private String description;

    private String manufacturer;
  
    private String brand;
    
      @NotNull(message ="Enter asset  code, is not null")
    @UniqueAssetCode
    private String assetCode; // fk must be unique like barcode id

    private String model;

    @NotNull(message ="please select asset  current condition")
    private String currentCondition; // in use ,  in  store

    @NotNull(message ="please select asset quality condition ")
    private String qualityCondition;//  new  ,good,used,slitly used
    @NotNull(message ="asset price is not null")
    private float price;
   
    private boolean assigned;
    @NotNull(message ="category is not null")
    private Catagory catagory;
    private String status;// in store, in use(assignd) , need maintenance

    public AssetDto() {
    }

    public AssetDto(String assetName, String description, String manufacturer, String brand, String assetCode, String model, String currentCondition, String qualityCondition, float price, boolean assigned, Catagory catagory, String status) {
        
        this.assetName = assetName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.assetCode = assetCode;
        this.model = model;
        this.currentCondition = currentCondition;
        this.qualityCondition = qualityCondition;
        this.price = price;
        this.assigned = assigned;
        this.catagory = catagory;
        this.status = status;
    }

   



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

  
 public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public String getQualityCondition() {
        return qualityCondition;
    }

    public void setQualityCondition(String qualityCondition) {
        this.qualityCondition = qualityCondition;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
    
    
}
