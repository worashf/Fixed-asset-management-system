<%-- 
    Document   : adminmaster
    Created on : May 9, 2019, 11:26:19 AM
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



                    <div class="panel panel-default">

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav navbar bg-light">
                                                 <s:url var ="requestlisturl" value ="/request/request_list"/>
                                       <s:url var ="personallisturl" value ="/request/personal_asset"/>
                               <s:url var="request_url" value ="/request/request_page"/> 
                                 <s:url var="requestApproveBymanagerurl" value ="/request/requestApproveManager"/> 
                                 <s:url var="requestApproveByStoreKepeerurl" value ="/request/store-kepeer-request-list"/>     
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${request_url}" ><h5>New Request</h5></a>
                                </li>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${personallisturl}" ><h5>Your Asset</h5></a>
                                </li>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${requestlisturl}"  ><h5>Request List</h5> </a>
                                </li>
                                <li class="nav-item  font-weight-bold " ><a class ="nav-link" href="${requestApproveBymanagerurl}" ><h5>Approved Requests </h5></a>
                                </li>
                                  <li class="nav-item font-weight-bold mr-auto" ><a class ="nav-link" href="${requestApproveByStoreKepeerurl}"><h5>Completed Requests</h5> </a>
                                </li>
                            </ul>






                            <!-- type of user -->
                            <div class="row">

                                <div class=" mt-3 col-md-6 col-lg-3">
                                    <div class="widget-small info coloured-icon"><i class="icon fa fa-star fa-4x"></i>
                                        <div class="info">
                                            <h4>Requests</h4>
                                            <p><b>5</b></p>
                                            <a href="#">
                                                <div class="panel-footer text-info">
                                                    <span class="pull-left">View Details</span>
                                                    <span class="pull-right"><i class="fa fa-arrow-circle-right "></i></span>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
      <div class="ml-5 mt-3">
                                       <p><strong> Department: </strong> <span  class="ml-2 text-info" >${dept.name}</span> </br>
                              <strong> First name: </strong><span class="ml-2 text-info"> ${emp.firstName}</span> </br>
                              <strong> Last name:</strong> <span class="ml-2 text-info">  ${emp.lastName}</span></br>
                              <strong> User name: </strong><span class="ml-2 text-info"> ${user.username} </span>
                            </p>  
                                </div>
                                <c:if test="${param.act eq 'manager_request_approve'}">
                                    <h3 class=" mt-3 ml-5 text-success"> Approved successfully</h3>
                                </c:if>
                                <c:if test="${param.act eq 'manager-decline'}">
                                    <h3 class=" mt-3 ml-5 text-success"> Decline successfully</h3>
                                </c:if>
                            </div>

  <div class="tile">
                                <div class="tile-body">
                                    <table class="table table-hover table-bordered" id="sampleTable">
                                        <thead>
                                            <tr>
                                                
                                                <th>Item 1</th>
                                                 <th>First Name</th>
                                                 <th>Last Name</th>
                                                   <th>Department Name</th>
                                                   <th>Action</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var ="req" items ="${requests}">
                                                <tr> 
                                                    <td>${req.item1}</td>
                                                    <td>${req.user.empployee.firstName}</td>
                                                     <td>${req.user.empployee.lastName}</td>
                                                      <td>${req.user.empployee.department.name}</td>
                                                     <s:url var="url_approve" value="/request/requestapprove_page">
                                        <s:param name="requestId" value="${req.requestId}"/>
                                    </s:url> 
                                   
                                  
                               
                                   <td> 
                                       <a href="${url_approve}">View detail</a>
                                   </td>
                                              
                                                </tr>
                                            </c:forEach>


                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        
                       



                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                      
                       
                     
                    </div>
                </div>
        </main>


        <s:url var = "jqueryurl" value ="/resource/js/jquery-3.2.1.min.js"/>
        <script src="${jqueryurl}" type = "text/javascript"></script>
        <s:url var="urlpopper" value="/resource/js/popper.min.js" />
        <script src="${urlpopper}"></script>
        <s:url var="urlboot" value="/resource/js/bootstrap.min.js" />
        <script src="${urlboot}"></script>
        <s:url var="urlmain" value="/resource/js/main.js" />
        <script src="${urlmain}"></script>
        <!-- The javascript plugin to display page loading on top-->
        <s:url var="urlpace" value="/resource/js/plugin/pace.min.js" />
        <script src="${urlpace}"></script>
        <s:url var="urljqlib" value="/resource/js/jquery-3.2.1.min.js" />
        <script src="${urljqlib}"></script>
        <!-- Page specific javascripts-->
        <s:url var="urlchart" value="/resource/js/plugin/chart.js" />
        <script type="text/javascript" src="${urlchart}"></script>
        <!-- Data table plugin-->
        <s:url var="urltable" value="/resource/js/plugin/jquery.dataTables.min.js" />
        <s:url var="urlboottable" value="/resource/js/plugin/dataTables.bootstrap.min.js" />
        <s:url var="urlcalendar" value="/resource/js/plugin/fullcalendar.min.js" />
        <script type="text/javascript" src="${urltable}"></script>
        <script type="text/javascript" src="${urlboottable}"></script>
        <script type="text/javascript" src="${urlcalendar}"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>


    </body>
</html>

