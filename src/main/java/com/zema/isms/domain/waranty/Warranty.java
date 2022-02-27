/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain.waranty;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.Document;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;





/**
 *
 * @author ewawuye
 */
@Entity
@Table(name="warranty")
public class Warranty implements Serializable {

    @Id
  @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name ="warrantyId")
    private String warrantyId;
 @Column(name ="warrantyName")
   @NotNull(message ="waranty name is not null")
    private String warrantyName;
  @Column(name ="startDate")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull(message = "warranty start date is not null")
    private Date startDate;
@   Column(name ="endDate")
     @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull(message = "warranty end date is not null")
    private Date endDate;
@   Column(name ="description")
    private String description;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "assetId")
    private Asset asset;
   @OneToMany(mappedBy = "warranty",fetch = FetchType.LAZY)
   private List<Document> documents;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
   
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
   public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getWarrantyName() {
        return warrantyName;
    }

    public void setWarrantyName(String warrantyName) {
        this.warrantyName = warrantyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

   
}
