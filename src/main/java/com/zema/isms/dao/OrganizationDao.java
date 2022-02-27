/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.Organization;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface OrganizationDao {
     public void saveOrganization(Organization o);

    public void updateOrganization(Organization o);

    public void deleteOrganization(Organization o);

    public void deleteOrganization(String organizationId);

    public Organization   findByOrganizationId(String organizationId);
     public Organization  getByOrgName(String orgName);
    public List<Organization> findAllOrganization();

    public List<Organization> findByProperty(String propName, Object propValue);
}
