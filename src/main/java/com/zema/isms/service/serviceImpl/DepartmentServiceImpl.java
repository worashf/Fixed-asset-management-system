/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.DepartmentDao;
import com.zema.isms.dao.OrganizationDao;

import com.zema.isms.domain.Department;
import com.zema.isms.domain.Organization;
import com.zema.isms.service.DepartmentService;
import java.util.List;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */

@Service
@Transactional
public class DepartmentServiceImpl  implements DepartmentService {
  @Autowired
	private SessionFactory sessionFactory;
    @Autowired
    private DepartmentDao  departmentDao;
         @Autowired
    private OrganizationDao orgdao;

    @Override
    public void registerDepartment(String orgId,Department d) {
        Session session = sessionFactory.getCurrentSession();
          Organization org = orgdao.findByOrganizationId(orgId);
        
        d.setOrganization(org);
     
       //Organization org = (Organization)session.get(Organization.class, orgId);
     
      org.getDepartments().add(d);
        departmentDao.saveDepartment(d);
    }

    @Override
    public void editDepartment(Department d) {
        departmentDao.updateDepartment(d);
        
    }

    @Override
    public void removeDepartment(Department d) {
        departmentDao.deleteDepartment(d);
    }

    @Override
    public Department searchByDepartmentId(String departmentId) {
       return  departmentDao.findByDepartmentId(departmentId);
    
    }

    @Override
    public List<Department> getDepartmentList() {
         return departmentDao.findAllDepartment();
    }
// further add search by dept name 

    @Override
    public List<Department> getDepartmentListByOrgId(String orgId) {
         return null;
    }

    @Override
    public Department searchDepartmentByName(String name) {
         Department dept = null;
         try{
         dept =    departmentDao.getDepartmentByName(name);
         }
         catch(NoResultException ex){
             dept = null;
         }
        return dept;
    }

    @Override
    public int retriveDepartmentCount() {
       int count =0;
       try{
         count =departmentDao.getDepartmentCount();
       }
       catch(NoResultException ex){
           
       }
       return count;
    }
    
}
