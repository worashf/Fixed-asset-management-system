/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;

import com.zema.isms.domain.waranty.Warranty;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ewawuye
 */
@Entity
@Table(name ="asset")
public class Asset implements Serializable {

    @Id
     @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name ="assetId")
    private String assetId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "catagoryId")
    private Catagory catagory; // fk for  asset  
    @OneToOne(mappedBy ="asset",fetch = FetchType.LAZY)
    private Warranty warranty;

    @ManyToOne
   @JoinColumn(name ="employeeId")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Column(name ="assetName")
    
    private String assetName;
     @Column(name ="description")
    private String description;
        @Column(name ="manufacturer")
    private String manufacturer;
    @Column(name ="brand")
    
    private String brand;
   

        @Column(name ="assetCode",unique=true)
   private String assetCode; // fk must be unique like barcode id
    @Column(name ="amodel")
    private String model;
       @Column(name ="currentCondition")
   
    private String currentCondition; // in use ,  in  store
    @Column(name ="qualityCondition")
    
    private String qualityCondition;//  new  ,good,used,slitly used
     @Column(name ="price")
    private float price;
   // @Column(nullable = false,columnDefinition = "boolean default true")
         @Column(name ="assigned")
    private boolean assigned;
     @OneToOne(mappedBy ="asset",fetch = FetchType.LAZY)
    private AssignedAsset assignedAsset;
     @OneToMany(mappedBy = "asset" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AssetHistory> assetHistorys;

    public List<AssetHistory> getAssetHistorys() {
        return assetHistorys;
    }

    public void setAssetHistorys(List<AssetHistory> assetHistorys) {
        this.assetHistorys = assetHistorys;
    }

    public AssignedAsset getAssignedAsset() {
        return assignedAsset;
    }

    public void setAssignedAsset(AssignedAsset assignedAsset) {
        this.assignedAsset = assignedAsset;
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

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
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

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
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
    

}
