/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Organization;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface OrganizationService {
    
    /**
     * save organization information
     * @param o 
     */
    public  void registerOrganization(Organization o);
    /**
     * update organization information
     * @param o 
     */
    public void editOrganization(Organization o);
    /**
     *  delete organization 
     * @param organizationId 
     */
    public void  removeOrganization(Organization o );
    /**
     *  search Organization  by id
     * @param organizationId
     * @return 
     */
    public Organization searchByOrganizationId(String organizationId);
    public Organization searchbyOrganizationName(String orgName);
    
    public List<Organization> getOrganizationList();
    
}
