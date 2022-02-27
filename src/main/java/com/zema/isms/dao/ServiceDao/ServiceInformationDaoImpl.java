/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.ServiceDao;

import com.zema.isms.domain.serviceInformation.ServiceInformation;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public class ServiceInformationDaoImpl implements ServiceInformationDao {

    @Override
    public void saveServiceInformation(ServiceInformation si) {
        
    }

    @Override
    public void updateServiceInformation(ServiceInformation si) {
         
    }

    @Override
    public void deleteServiceInformation(ServiceInformation si) {
        
    }

    @Override
    public void deleteServiceInformation(Integer ServiceId) {
      
    }

    @Override
    public ServiceInformation findByServiceId(Integer ServiceId) {
           return null; 
    }

    @Override
    public List<ServiceInformation> findAllServiceInformation() {
         return null;
    }

    @Override
    public List<ServiceInformation> findByProperty(String propName, Object propValue) {
         return null; 
    }
    
}
