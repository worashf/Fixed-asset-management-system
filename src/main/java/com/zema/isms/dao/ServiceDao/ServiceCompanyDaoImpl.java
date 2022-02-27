/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.ServiceDao;

import com.zema.isms.domain.serviceInformation.ServicedCompany;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ewawuye
 */
public class ServiceCompanyDaoImpl implements ServicedCompanyDao {
     @Autowired
   private SessionFactory sf;
    @Override
    public void saveServicedCompany(ServicedCompany sc) {
        sf.getCurrentSession().save(sc);
    }

    @Override
    public void updateServicedCompany(ServicedCompany sc) {
       sf.getCurrentSession().update(sc);
    }

    @Override
    public void deleteServicedCompany(ServicedCompany sc) {
        
    }

    @Override
    public void deleteServicedCompany(Integer CompanyId) {
        
    }

    @Override
    public ServicedCompany findByCompanyId(Integer CompanyId) {
     return null;
    }

    @Override
    public List<ServicedCompany> findAllServicedCompany() {
      return null;   
    }

    @Override
    public List<ServicedCompany> findByProperty(String propName, Object propValue) {
      return null;
    }
    
}
