/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain.serviceInformation;

import com.zema.isms.domain.Asset;
import java.sql.Date;
import javax.persistence.ManyToOne;

/**
 *
 * @author ewawuye
 */
public class ServiceInformation {
    
    private String ServiceId;
    private Asset Asset;
    @ManyToOne
    private ServicedCompany servicedCompany; // fk for  company  serviced asset
    private String serviceType;  // maitenance , inspection
    private Double LaborCost;
    private Double  PartCost;
    private Double  Tax;
   
    private Date StartDate;
    private Date CompletedDate;
    private String Description;
    private Byte[] attachment; // attachment

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String ServiceId) {
        this.ServiceId = ServiceId;
    }

    public Asset getAsset() {
        return Asset;
    }

    public void setAsset(Asset Asset) {
        this.Asset = Asset;
    }

    public ServicedCompany getServicedCompany() {
        return servicedCompany;
    }

    public void setServicedCompany(ServicedCompany servicedCompany) {
        this.servicedCompany = servicedCompany;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Double getLaborCost() {
        return LaborCost;
    }

    public void setLaborCost(Double LaborCost) {
        this.LaborCost = LaborCost;
    }

    public Double getPartCost() {
        return PartCost;
    }

    public void setPartCost(Double PartCost) {
        this.PartCost = PartCost;
    }

    public Double getTax() {
        return Tax;
    }

    public void setTax(Double Tax) {
        this.Tax = Tax;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getCompletedDate() {
        return CompletedDate;
    }

    public void setCompletedDate(Date CompletedDate) {
        this.CompletedDate = CompletedDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(Byte[] attachment) {
        this.attachment = attachment;
    }

   
    

}
