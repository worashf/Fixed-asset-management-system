<%-- 
    Document   : access-denied
    Created on : Sep 18, 2019, 8:37:10 AM
    Author     : ewawuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
  
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Asset management- ${title}</title>
        <!-- Main CSS  -->
        <s:url var ="mainurl" value ="/resource/css/main.css"/>
        <link href="${mainurl}" rel="stylesheet" type="text/css"> 
      <s:url var ="styleurl" value ="/resource/css/bootstrap.min"/>
        <link href="${styleurl}" rel="stylesheet" type="text/css"> 
        <!-- Custom CSS -->
        <s:url var ="customurl" value ="/resource/css/sb-admin-2.css"/>
        <link href="${customurl}" rel="stylesheet" type="text/css">

        <!-- font awasome -->
        <s:url var ="fonturl" value ="/resource/css/font-awesome-4.7.0/css/font-awesome.min.css"/>
        <link href= "${fonturl}" rel="stylesheet" type="text/css"/> 

        <!-- Font-icon css-->
    </head>
      <body class="app sidebar-mini rtl">


     <!-- Navigation -->
        <%@include file="./shared/headerNav.jsp"%>
        <!-- Side Navigation -->
        <%@include file="./shared/sideNav.jsp"%>
        
        <main class="app-content">

            <div class="row">
                <div class="col-md-12">
                      <!-- Nav tabs -->
                            <ul class="nav navbar bg-light">
                                                 <s:url var ="requestlisturl" value ="/request/request_list"/>
                                       <s:url var ="personallisturl" value ="/request/personal_asset"/>
                               <s:url var="request_url" value ="/request/request_page"/> 
                                 <s:url var="requestApproveBymanagerurl" value ="/request/requestApproveManager"/> 
                                 
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${request_url}" ><h5>New Request</h5></a>
                                </li>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${personallisturl}" ><h5>Your Asset</h5></a>
                                </li>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${requestlisturl}"  ><h5>Request List</h5> </a>
                                </li>
                                <li class="nav-item font-weight-bold mr-auto" ><a class ="nav-link" href="${requestApproveBymanagerurl}"><h5>Approved Requests </h5></a>
                                </li>
                             
                            </ul>

                    
                    <h1  class = "text-danger"> You are not authorized to access this page</h1>
                </div>
                    
            </div>
        </main>
    </body>
</html>
