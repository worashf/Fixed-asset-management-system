/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.ServiceDao;

import com.zema.isms.domain.serviceInformation.ServicedCompany;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface ServicedCompanyDao {
    public void saveServicedCompany(ServicedCompany sc);

    public void updateServicedCompany(ServicedCompany sc);

    public void deleteServicedCompany(ServicedCompany sc);

    public void deleteServicedCompany(Integer CompanyId);

    public ServicedCompany findByCompanyId(Integer CompanyId);

    public List<ServicedCompany> findAllServicedCompany();

    public List<ServicedCompany> findByProperty(String propName, Object propValue);
}
