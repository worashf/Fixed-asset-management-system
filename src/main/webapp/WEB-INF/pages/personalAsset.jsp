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

                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${request_url}" ><h5>New Request</h5></a>
                                </li>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${personallisturl}" ><h5>Your Asset</h5></a>
                                </li>
                                <li class="nav-item font-weight-bold " ><a class ="nav-link" href="${requestlisturl}"  ><h5>Request List</h5> </a>
                                </li>
                                <li class="nav-item font-weight-bold mr-auto" ><a class ="nav-link" href="${requestApproveBymanagerurl}"  ><h5>Approved Requests</h5> </a>
                                </li>
                            </ul>






                            <!-- type of user -->
                            <div class="row">

                                <div class=" mt-3 col-md-6 col-lg-3">
                                    <div class="widget-small info coloured-icon"><i class="icon fa fa-shopping-cart"></i>
                                        <div class="info">
                                            <h4>Your Assets</h4>
                                            <p><b>${resultsCount}</b></p>
                                          
                                        </div>
                                    </div>
                                </div>
                        
                                
                            </div>


                       
                



                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        ${dept.name}</br>
                        ${emp.firstName}</br>
                        ${user.username}
                     
        <%-- table body--%>
                            <div class="tile">
                                <h4 class="tile-title">Your Asset List</h4> 
                                <div class="tile-body">


                                    <table class="table table-hover table-bordered" id ="samleTable" >
                                        <thead>
                                            <tr>


                                                <th>First Name</th>
                                                <th> Middle Name</th>
                                                <th> Last Name</th>
                                                <th> Employee Code</th>
                                                <th> Job Title</th>
                                                <th> Employee department</th>

                                                <th>Asset Code</th>
                                                <th> Category</th>
                                                <th> Brand</th>
                                                <th> Item Quantity</th>
                                                <th> Check In  Date</th>
                                             
                                                 



                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var ="assignedAsset" items = "${assetlist}">
                                                <tr>
                                                    <td>${assignedAsset.employee.firstName}</td>
                                                    <td>${assignedAsset.employee.middleName}</td>
                                                    <td>${assignedAsset.employee.lastName}</td>
                                                    <td>${assignedAsset.employee.code}</td>
                                                    <td>${assignedAsset.employee.jobPosition}</td>
                                                    <td>${assignedAsset.employee.department.name}</td>
                                                   
                                                    <td>${assignedAsset.asset.assetCode}</td>
                                                 
                                                    <td>${assignedAsset.asset.catagory.catagoryName}</td>
                                                    <td>${assignedAsset.asset.brand}</td>
                                                    <td>${assignedAsset.quantity}</td>
                                                    <td>${assignedAsset.assignDate}</td>
                                      </tr>

                                            </c:forEach>

                                        </tbody>
                                    </table>

                                </div>

                             
                            </div>  <%-- table end --%>
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

