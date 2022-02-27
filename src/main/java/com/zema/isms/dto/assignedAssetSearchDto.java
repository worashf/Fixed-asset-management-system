package com.zema.isms.dto;

/**
 * Created by uppert on 10/28/2019.
 */

public class assignedAssetSearchDto {
    private  String categoryId;
    private  String departmentId;
    private String deptName;
    private  String catName;

    public String getDeptName() {
        return deptName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
