/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;



import javax.persistence.Column;


import javax.persistence.GeneratedValue;

import javax.persistence.Id;


import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author ewawuye
 */
@Entity
@Table(name ="catagory")
public class Catagory implements Serializable {
    
    @Id
  @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
        @Column(name ="catagoryId")
    private String catagoryId;
    @Column(name ="catagory_name")
    @NotNull(message = "catagory name is not null") 
   private String catagoryName; // catagory name
     @Column(name ="description")
    private String description;
   
  @OneToMany(mappedBy = "catagory" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Asset>  asset;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Asset> getAsset() {
        return asset;
    }

    public void setAsset(List<Asset> asset) {
        this.asset = asset;
    }


          
    public Catagory() {
    }

    public String getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    
 

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

   

    
    

}
