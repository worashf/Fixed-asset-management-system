/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.OrganizationDao;
import com.zema.isms.dao.daoConfig.baseDao;
import com.zema.isms.domain.Organization;
import com.zema.isms.service.OrganizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Service
@Transactional
public class OrganizationServiceImpl  implements OrganizationService {
 
      @Autowired
    private OrganizationDao orgdao;
    @Override
    public void registerOrganization(Organization o) {
        orgdao.saveOrganization(o);
    }

  

    @Override
    public void removeOrganization(Organization o) {
       orgdao.deleteOrganization(o);
    }

    @Override
    public Organization searchByOrganizationId(String organizationId) {
    return orgdao.findByOrganizationId(organizationId);
    }

    @Override
    public void editOrganization(Organization o) {
       orgdao.updateOrganization(o);
    }

    @Override
    public List<Organization> getOrganizationList() {
        return  orgdao.findAllOrganization();
    }

    @Override
    public Organization searchbyOrganizationName(String orgName) {
        return orgdao.getByOrgName(orgName);
    }

   
        
    

    
    
}
