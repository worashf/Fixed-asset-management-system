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
public interface ServiceInformationDao {
    public void saveServiceInformation(ServiceInformation si);

    public void updateServiceInformation(ServiceInformation si);

    public void deleteServiceInformation(ServiceInformation si);

    public void deleteServiceInformation(Integer ServiceId);

    public ServiceInformation findByServiceId(Integer ServiceId);

    public List<ServiceInformation> findAllServiceInformation();

    public List<ServiceInformation> findByProperty(String propName, Object propValue);
}
