<%-- 
    Document   : header
    Created on : Nov 25, 2018, 7:47:08 AM
    Author     : ewawuye
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="">AMS</a>
      <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
      <!-- User Menu-->
           <h2 class ="font-weight-bold text-white mt-3 ml-5">Civil Service Commission Fixed Asset Management System </h2>
            <ul class="  nav navbar bg-light ml-5   ">
                                    <s:url var ="requestlisturl" value ="/request/request_list"/>
                                       <s:url var ="personallisturl" value ="/request/personal_asset"/>
                               <s:url var="request_url" value ="/request/request_page"/> 
                                 <s:url var="requestApproveBymanagerurl" value ="/request/requestApproveManager"/> 
                                 
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${request_url}" ><h5>New Request</h5></a>
                                </li>
                                <li class =" nav-item font-weight-bold "><a  class ="nav-link " href="${personallisturl}" ><h5>Your Asset</h5></a>
                                </li>
                            
                            </ul>

        <ul class="app-nav">
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class=""> <f:form action="${pageContext.request.contextPath}/logout" method="POST">
          <input type="submit" value="Logout"/>
      </f:form></i></a>
            <span style="float: right; color:white">
	<a  class ="text-danger" href="?lang=en">en</a> 
	| 
	<a class ="text-danger" href="?lang=am">am</a>
  </span>
        </li>
        </ul>
    </header>
