/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.domain;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ewawuye
 */
@Entity
@Table(name = "request")
public class Request implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
      @Column(name="requestId")
    private String requestId;
    @Temporal(javax.persistence.TemporalType.DATE)
        @Column(name=" requestDate")
    private Date requestDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToMany
    @JoinTable(
				name="department_request",
				joinColumns=@JoinColumn(name="request_Id"),
				inverseJoinColumns=@JoinColumn(name="department_Id"))
    private List<Department>departments;
    @NotNull
   @Column(name="item1")
    private String item1;
   @Column(name="item2")
     private String item2;
         @Column(name="item3")
     private String item3;
      @Column(name="item4")
     private String item4;
          @Column(name="item5")
     private String item5;
       @NotNull
          @Column(name="quantity1")
     private int quantity1;
          @Column(name="quantity2")
     private int quantity2;
             @Column(name="quantity3")
     private int quantity3;
                @Column(name="quantity4")
     private int quantity4;
                   @Column(name="quantity5")
     private int quantity5;
     
     // aproved quantity
   @Column(name="approved1")
     private int approved1;
        @Column(name="approved2")
     private int approved2;
           @Column(name="approved3")
     private int approved3;
              @Column(name="approved4")
     private int approved4;
                 @Column(name="approved5")
     private int approved5;
      @Column(name="status")
     private boolean status; // aprove,unaprove ,pending
         @Column(name="decline")
     private boolean decline;
            @Column(name="description")
    private String description;
               @Column(name="aprovalDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date aprovalDate;
     @Column(name="statusStage")
     private Integer statusStage;  // 0= START,1= DIRECTER-APPROVED,2 DIRECTER-DECLINE, 3= OFFICER APPROVED, 4= OFFICER-DECLINE, 5= STORE-KEPEER-COMPLATE
     
     
     @Column(name="managerComment")
     private String managerComment;

    public String getManagerComment() {
        return managerComment;
    }

    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }
     
    public Integer getStatusStage() {
        return statusStage;
    }

    public void setStatusStage(Integer statusStage) {
        this.statusStage = statusStage;
    }

 
        
    public boolean isDecline() {
        return decline;
    }

    public void setDecline(boolean decline) {
        this.decline = decline;
    }

    public int getApproved1() {
        return approved1;
    }

    public void setApproved1(int approved1) {
        this.approved1 = approved1;
    }

    public int getApproved2() {
        return approved2;
    }

    public void setApproved2(int approved2) {
        this.approved2 = approved2;
    }

    public int getApproved3() {
        return approved3;
    }

    public void setApproved3(int approved3) {
        this.approved3 = approved3;
    }

    public int getApproved4() {
        return approved4;
    }

    public void setApproved4(int approved4) {
        this.approved4 = approved4;
    }

    public int getApproved5() {
        return approved5;
    }

    public void setApproved5(int approved5) {
        this.approved5 = approved5;
    }

    
    
    
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }



    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public String getItem5() {
        return item5;
    }

    public void setItem5(String item5) {
        this.item5 = item5;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(int quantity1) {
        this.quantity1 = quantity1;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
    }

    public int getQuantity4() {
        return quantity4;
    }

    public void setQuantity4(int quantity4) {
        this.quantity4 = quantity4;
    }

    public int getQuantity5() {
        return quantity5;
    }

    public void setQuantity5(int quantity5) {
        this.quantity5 = quantity5;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAprovalDate() {
        return aprovalDate;
    }

    public void setAprovalDate(Date aprovalDate) {
        this.aprovalDate = aprovalDate;
    }
    

}
