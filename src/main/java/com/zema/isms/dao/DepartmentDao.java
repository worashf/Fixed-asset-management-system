/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.Department;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface DepartmentDao {
    public void saveDepartment (Department d);

    public void updateDepartment (Department d);

    public void deleteDepartment (Department d);

    public void deleteDepartment (String departmentId);

    public Department   findByDepartmentId(String departmentId);
    public Department   getDepartmentByName(String deptName);

    public List<Department> findAllDepartment ();
    
    public List<Department> findByProperty(String propName, Object propValue);
   public int getDepartmentCount();
}
