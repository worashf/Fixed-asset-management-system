/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao;

import com.zema.isms.domain.SystemRole;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface RoleDao {
   public void saveRole (SystemRole r);

    public void updateRole (SystemRole r);

    public void deleteRole (SystemRole r);

    public void deleteAsset (String AssetId);

    public SystemRole     findByRoletId(String RoleId);
    
    public SystemRole   findByRoleName(String roleName);

    public List<SystemRole> findAllRole ();
}
