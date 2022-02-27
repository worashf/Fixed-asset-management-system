/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="assignedasset")
public class AssignedAsset implements Serializable { 
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
       @Column(name ="id")
    private String id;
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="assetId")
   private Asset asset;
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="employeeId")
   private Employee employee;
          @Column(name ="quantity")
   private Integer quantity;
          
    @Column(name="due_date")
   @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull(message = "assigned date is not null")
       
  private Date assignDate;
       @Column(name ="remark")
  private String remark;

    @Column(name ="checkOutNumber")
  //this field is for pick asset 
  private String checkOutNumber;

    public String getCheckOutNumber() {
        return checkOutNumber;
    }

    public void setCheckOutNumber(String checkOutNumber) {
        this.checkOutNumber = checkOutNumber;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

   
    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
    
    
}
