/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.EmployeeDao;
import com.zema.isms.dao.RoleDao;
import com.zema.isms.dao.UserDao;
import com.zema.isms.domain.Employee;
import com.zema.isms.domain.Roles;
import com.zema.isms.domain.SystemRole;
import com.zema.isms.domain.User;
import com.zema.isms.dto.UserDto;
import com.zema.isms.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ewawuye
 */
@Service("userDetailService")
public class UserServiceImpl implements UserDetailsService, UserService {
@Autowired
 private UserDao userdao;
@Autowired
 private RoleDao roledao;

@Autowired
 private EmployeeDao empdao;

@Transactional
    @Override
    public void registerUser(UserDto u) {
              String roleName;
              String roleName1;
                String roleName2;
		User userEntity; 
		List<String> roles = new ArrayList<>();
		
        
                    
		   
                    if(u.getRole().equals("ADMIN")){
                       roleName1 = Roles.PERSONAL.toString();
                        roleName2 = Roles.ADMIN.toString();
                        roles.add( roleName1);
                          roles.add(roleName2);
                           userEntity = convertUserDTOtoUserEntity(u, roles);
                             userdao.saveUser(userEntity);
                    }
                    else if(u.getRole().equals("DIRECTER")){
                      roleName1 = Roles.PERSONAL.toString();
                      roleName2 = Roles.DIRECTER.toString();
                      roles.add( roleName1);
                      roles.add(roleName2);
                       userEntity = convertUserDTOtoUserEntity(u, roles);
                         userdao.saveUser(userEntity);
                    }
                    else if(u.getRole().equals("KEPEER")){
                            roleName1 = Roles.PERSONAL.toString();
                      roleName2 = Roles.KEPEER.toString();
                      roles.add( roleName1);
                      roles.add(roleName2);
                       userEntity = convertUserDTOtoUserEntity(u, roles);
                         userdao.saveUser(userEntity);
                    }
                else if(u.getRole().equals("MANAGER")){
                     roleName1 = Roles.PERSONAL.toString();
                      roleName2 = Roles.MANAGER.toString();
                      roles.add( roleName1);
                      roles.add(roleName2);
                       userEntity = convertUserDTOtoUserEntity(u, roles);
                         userdao.saveUser(userEntity);
                    }
                      
                    else{
			roleName = Roles.PERSONAL.toString();
                        userEntity = convertUserDTOtoUserEntity(u, roleName);
                         userdao.saveUser(userEntity);
		   } 
                
            
   
    }
 @Transactional
    @Override
    public void editUser(User u) {
      userdao.updateUser(u);
    }

    @Override
    public void removeUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 @Transactional
    @Override
    public User searchByUserId(String userId) {
     return userdao.findByUserId(userId);
    }
    @Transactional
    @Override
    public List<User> getUserList() {
        return userdao.findAllUser();
    }
@Transactional
    @Override
    public User searchUserByName(String name) {
        
        return userdao.findByUserName(name);
    }
    private User convertUserDTOtoUserEntity(UserDto user, String userRole) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User userEntity = new User();
		SystemRole role;
		
		userEntity.setUsername(user.getUsername());
                userEntity.setEnable(true);
		userEntity.setPassword(encoder.encode(user.getPassword()));
		role =  roledao.findByRoleName(userRole);
		userEntity.addRole(role);
		
		return userEntity;
	}
      private User convertUserDTOtoUserEntity(UserDto user, List userRole) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User userEntity = new User();
		SystemRole role;
		
		userEntity.setUsername(user.getUsername());
                userEntity.setEnable(true);
                userEntity.setPassword(encoder .encode(user.getPassword()));
		
                for(Object role1:userRole){
		role = roledao.findByRoleName((String) role1);
		userEntity.addRole(role);
                }
		return userEntity;
	}
@Transactional
    @Override
    public boolean isUserNameInuse(String name) {
          boolean userInDb = true;
		if (userdao.findByUserName(name) == null)
                {
                    userInDb = false;
                }
                
		return userInDb;
    }
// security service
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userdao.findByUserName(username);
		
	boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        Collection<? extends GrantedAuthority> authList = getUserAuthorities(user.getRoles());
        
		return new org.springframework.security.core.userdetails.User(
					user.getUsername(),

                   user.getPassword(),
					user.isEnable(),
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					authList);
    }
    
    	private Collection<? extends GrantedAuthority> getUserAuthorities(Set<SystemRole> modelAuthSet) {
		
		List<SystemRole> modelAuthList = convertRolesSetToList(modelAuthSet);
		
        List<GrantedAuthority> authList = getGrantedUserAuthority(modelAuthList);
        return authList;
    }

	private List<SystemRole> convertRolesSetToList(Set<SystemRole> modelAuthSet) {
		return new ArrayList<>(modelAuthSet);
	}
	
	private List<GrantedAuthority> getGrantedUserAuthority (List<SystemRole> modelAuthList){
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (SystemRole auth : modelAuthList){
			authorities.add(new SimpleGrantedAuthority(auth.getName()));
		}
		
		return authorities;
	}
   @Transactional
    @Override
    public void registerUserWithEmp(UserDto u, String employeeId ) {
        String roleName;
              String roleName1;
                String roleName2;
		User userEntity; 
		List<String> roles = new ArrayList<>();
		
        
                    
		   
                    if(u.getRole().equals("ADMIN")){
                       roleName1 = Roles.PERSONAL.toString();
                        roleName2 = Roles.ADMIN.toString();
                        roles.add( roleName1);
                          roles.add(roleName2);
                           userEntity = convertUserDTOtoUserEntity(u,employeeId , roles);
                             userdao.saveUser(userEntity);
                    }
                    else if(u.getRole().equals("DIRECTER")){
                      roleName1 = Roles.PERSONAL.toString();
                      roleName2 = Roles.DIRECTER.toString();
                      roles.add( roleName1);
                      roles.add(roleName2);
                       userEntity = convertUserDTOtoUserEntity(u,employeeId , roles);
                         userdao.saveUser(userEntity);
                    }
                    else if(u.getRole().equals("KEPEER")){
                            roleName1 = Roles.PERSONAL.toString();
                      roleName2 = Roles.KEPEER.toString();
                      roles.add( roleName1);
                      roles.add(roleName2);
                       userEntity = convertUserDTOtoUserEntity(u,employeeId , roles);
                         userdao.saveUser(userEntity);
                    }
                else if(u.getRole().equals("MANAGER")){
                     roleName1 = Roles.PERSONAL.toString();
                      roleName2 = Roles.MANAGER.toString();
                      roles.add( roleName1);
                      roles.add(roleName2);
                       userEntity = convertUserDTOtoUserEntity(u, employeeId , roles);
                         userdao.saveUser(userEntity);
                    }
                      
                    else{
			roleName = Roles.PERSONAL.toString();
                        userEntity = convertUserDTOtoUserEntity(u, employeeId ,roleName);
                         userdao.saveUser(userEntity);
		   } 
    }
     private User convertUserDTOtoUserEntity(UserDto user,String emloyeeId, String userRole) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User userEntity = new User();
                  Employee emp = empdao.findByEmployeeId(emloyeeId);
		SystemRole role;
		
		userEntity.setUsername(user.getUsername());
                userEntity.setEnable(true);
                userEntity.setEmpployee(emp);
		userEntity.setPassword(encoder.encode(user.getPassword()));
		role =  roledao.findByRoleName(userRole);
		userEntity.addRole(role);
		
		return userEntity;
	}
      private User convertUserDTOtoUserEntity(UserDto user,String emloyeeId, List userRole) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User userEntity = new User();
                Employee emp = empdao.findByEmployeeId(emloyeeId);
		SystemRole role;
		
		userEntity.setUsername(user.getUsername());
                userEntity.setEnable(true);
                userEntity.setEmpployee(emp);
                userEntity.setPassword(encoder .encode(user.getPassword()));
		
                for(Object role1:userRole){
		role = roledao.findByRoleName((String) role1);
		userEntity.addRole(role);
                }
		return userEntity;
	}
}
