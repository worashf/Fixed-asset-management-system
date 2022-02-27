<%-- 
    Document   : adminmaster
    Created on : May 9, 2019, 11:26:19 AM
    Author     : ewawuye
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

                                     <s:url var="report_url" value ="/report/manage_report"/>
                                     <li class =" nav-item"><a  class ="nav-link font-weight-bold " href="${report_url}" ><h5>Assigned Report</h5></a>
                                </li>
                                   <s:url var="storereport_url" value ="/report/storeAssetReport"/>
                                   <li class =" nav-item mr-auto"><a  class ="nav-link font-weight-bold " href="${storereport_url}" ><h5>Store Report</h5></a>
                                </li>
                            </ul>

                           
                             

                              

                           <div class="tile">
                      
                           <%-- asset search start --%>
                            <div class="tile">
                                <h4 class="tile-title">Assigned  Asset By Department </h4>
                                <div class="tile-body"> 
                                    <s:url var ="reortByDeptUrl"  value="/report/reportByDepartment"/>
                                    <f:form action ="${reortByDeptUrl}" modelAttribute="dept" method ="get">
                                        <div class="form-row row ">

                                            <div class="form-group col-md-6 ">
                                                                       <f:select  path ="departmentId" class ="form-control">

                                                                            <f:options items="${departments}" itemLabel ="name" itemValue ="departmentId"/>


                                                                        </f:select>
           

                                            </div>
                                            
                                             <div class="form-group col-md-3">
                                               
                                                              <select   name ="exportvalue" type ="text" class ="form-control">
                                                                    
                                                                                    <option>word</option>
                                                                                            
                                                                                    <option >excel</option>
                                                                                  


                                                                  </select>
                                                            </div>
                                            <div class ="col-md-3">
                                                <a>  <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>View report</button></a>
                                            </div>
                                        </div>

                                    </f:form>
                                </div>  
                            </div>
                          <%-- asset search start --%>
                            <div class="tile">
                                <h4 class="tile-title">Assigned  Asset By Category </h4>
                                <div class="tile-body"> 
                                    <s:url var ="reportByCatagoryUrl"  value="/report/reportByCatagory"/>
                                    <f:form action ="${reportByCatagoryUrl}" modelAttribute="catagory" method="get">
                                        <div class="form-row row ">

                                            <div class="form-group col-md-6 ">
                                   <f:select  path ="catagoryId" class ="form-control">

                                                                            <f:options items="${catagorylist}" itemLabel ="catagoryName" itemValue ="catagoryId"/>


                                                                        </f:select>
                                            </div>
                                            
                                             <div class="form-group col-md-3">
                                                              <select   name ="exportvalue" type ="text" class ="form-control">
                                                                    
                                                                                    <option>word</option>
                                                                                            
                                                                                    <option >excel</option>
                                                                                    


                                                                  </select>
                                                            </div>
                                            <div class ="col-md-3">
                                                <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>View Report</button>
                                            </div>
                                        </div>

                                    </f:form>
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

