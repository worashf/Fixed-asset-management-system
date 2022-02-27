package com.zema.isms.domain;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * Created by uppert on 10/21/2019.
 */
@Entity
@Table(name="assethistory")
public class AssetHistory  implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="historyId")
    private String historyId;
 @Column(name="comment")
    private String  comment;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "assetId")
    private Asset asset;
    @Column(name="history_date")
   @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull(message = "return date is not null")
    private Date addDate;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
