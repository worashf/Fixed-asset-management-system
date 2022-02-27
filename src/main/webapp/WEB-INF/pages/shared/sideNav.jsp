<%-- 
    Document   : sidecontent
    Created on : Nov 25, 2018, 7:47:23 AM
    Author     : ewawuye
--%>

<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
        <s:url var ="logo_img" value = "/resource/image/csc_logo.jpg"/>
        <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="${logo_img}" alt="Logo Image" width ="70" height="70">
        <div>
          <p class="app-sidebar__user-name">Civil Service </p>
          <p class="app-sidebar__user-designation"> AMS</p>
        </div>
      </div>
      <ul class="app-menu">
           <s:url var="request_url" value ="/request/request_page"/> 
          <s:url var="dash_url" value ="/dashboard"/> 
          <s:url var="employee_url" value ="/employee/add"/>
          <s:url var="asset_url" value ="/asset/asset_reg"/>
           <s:url var="organization_url" value ="/organization/organization_reg"/>
           <s:url var="department_url" value ="/dept/dept_add"/>
              <s:url var="report_url" value ="/report/manage_report"/>
                      <s:url var="catagory_url" value ="/catagory/catagory_reg"/>
                      <s:url var = "security_url" value="/security/getSecutity"/>
        <li><a class="app-menu__item  " href="${dash_url}"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">Dashboard</span></a></li>
                
                <li><a class="app-menu__item  " href="${request_url}"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">Request Board</span></a></li>
          
                                <li><a class="app-menu__item  " href="${organization_url}"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">Department</span></a></li>
           
                               
                              
                                <li><a class="app-menu__item  " href="${employee_url}"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">Employee</span></a></li>
                
                                     
                                  
                               
                                    
        <li><a class="app-menu__item  " href="${catagory_url}"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">Category</span></a></li>
             
             
    
           <li><a class="app-menu__item  " href="${asset_url}"><i class="app-menu__icon fa fa-pie-chart"></i><span class="app-menu__label">Asset</span></a></li>
        
        
    
        <li><a class="app-menu__item  " href="${report_url}"><i class="app-menu__icon fa fa-pie-chart"></i><span class="app-menu__label">Report</span></a></li>
       
        

        <li><a class="app-menu__item  " href="${security_url}"><i class="app-menu__icon fa fa-pie-chart"></i><span class="app-menu__label">User</span></a></li>
      
        

        
        </ul>
    </aside>
