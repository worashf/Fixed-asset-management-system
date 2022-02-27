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
<s:url var="requestCompletedByStoreKepeerurl" value ="/request/finished-request"/> 
 
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${request_url}" ><h5>New Request</h5></a>
                                </li>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${personallisturl}" ><h5>Your Asset</h5></a>
                                </li>
                                <li class="nav-item font-weight-bold " ><a class ="nav-link" href="${requestlisturl}"  ><h5>Request List</h5> </a>
                                </li>
                                <li class="nav-item font-weight-bold " ><a class ="nav-link" href="${requestApproveBymanagerurl}"><h5>Approved Requests</h5> </a>
                                </li>
                                <li class="nav-item font-weight-bold " ><a class ="nav-link" href="${requestApproveByStoreKepeerurl}"><h5>Completed Requests</h5> </a>
                                </li>
                                      <li class="nav-item font-weight-bold mr-auto" ><a class ="nav-link" href="${requestCompletedByStoreKepeerurl}"><h5>Finished Requests</h5> </a>
                                </li>
                            </ul>






                            <!-- type of user -->
                            <div class="row">

                                <div class=" mt-3 col-md-6 col-lg-3">
                                    <div class="widget-small info coloured-icon"><i class="icon fa fa-shopping-cart"></i>
                                        <div class="info">
                                            <h4>Available Assets</h4>
                                            <p class="text-danger"><b>${count}</b></p>

                                        </div>
                                    </div>
                                </div>
                                <div class=" mt-3 col-md-6 ">
                                    <%-- asset search start --%>
                                    <div class="tile">
                                        <h4 class="tile-title">Available  Asset By Category </h4>
                                        <div class="tile-body"> 
                                            <s:url var ="assetBYcatagoryUrl"  value="/request/assetByCatagory"/>
                                            <f:form action ="${assetBYcatagoryUrl}" modelAttribute="catagory" method="get">
                                                <div class="form-row row ">

                                                    <div class="form-group col-md-6 ">
                                                        <f:select  path ="catagoryId" class ="form-control">

                                                            <f:options items="${catagorylist}" itemLabel ="catagoryName" itemValue ="catagoryId"/>


                                                        </f:select>
                                                    </div>
                                                    <div class ="col-md-3">
                                                        <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>View </button>
                                                    </div>
                                                </div>

                                            </f:form>
                                        </div>
                                        <!-- /.panel-body -->
                                    </div>

                                    <c:if test ="${param.act eq 'request_reg'}">
                                        <h5 class="font-weight-bold ml-5 mt-5 text-success">Request successfully created!</h5>
                                    </c:if>          

                                </div> 
                                            <p><strong> Department: </strong> <span  class="ml-2 text-info" >${dept.name}</span> </br>
                              <strong> First name: </strong><span class="ml-2 text-info"> ${emp.firstName}</span> </br>
                              <strong> Last name:</strong> <span class="ml-2 text-info">  ${emp.lastName}</span></br>
                              <strong> User name: </strong><span class="ml-2 text-info"> ${user.username} </span>
                            </p>
                            </div>


                            <div class="form-group row">
                                <div  class=" card-header col-md-3 col-form-label ">Number</div>
                                <div  class=" card-header col-md-3  col-form-label text-md-left">Item</div>
                                <div  class=" card-header col-md-3  col-form-label text-md-left mr-auto">Quantity(number)</div>

                            </div>
                            <s:url var ="request_reg" value="/request/request_reg"/>
                            <f:form action ="${request_reg}" modelAttribute="request" method="post">
                                <div class="form-group row ">
                                    <input type="hidden" name = "userId" value="${user.userId}"/>
                                    <input type="hidden" name ="departmentId" value="${dept.departmentId}"/>

                                    <label for="first_name" class=" col-md-2 card-header text-primary ">Item 1</label>
                                    <div class=" col-md-3">
                                        <f:errors path ="item1"  type="text"  class="text-dander"/>
                                        <f:input path ="item1" type="text"  class="form-control"/>

                                    </div>
                                    <div class="col-md-3">
                                        <f:errors path ="quantity1"  type="text"  class="text-dander"/>
                                        <f:input   path ="quantity1" type="text"  class="form-control"/>

                                    </div>              
                                </div>
                                <div class="form-group row">
                                    <label for="first_name" class="card-header text-primary col-md-2 ">Item 2</label>
                                    <div class="col-md-3">

                                        <f:input  path ="item2" type="text"  class="form-control"/>

                                    </div>
                                    <div class="col-md-3">

                                        <f:input  path  ="quantity2" type="text"  class="form-control"/>

                                    </div>              
                                </div>
                                <div class="form-group row">
                                    <label for="first_name" class="col-md-2 card-header text-primary">Item 3</label>
                                    <div class="col-md-3">

                                        <f:input  path  ="item3" type="text"  class="form-control"/>

                                    </div>
                                    <div class="col-md-3">

                                        <f:input  path  ="quantity3" type="text"  class="form-control"/>

                                    </div>              
                                </div>
                                <div class="form-group row">
                                    <label for="first_name" class="col-md-2 card-header text-primary ">Item 4</label>
                                    <div class="col-md-3">

                                        <f:input  path  ="item4" type="text"  class="form-control"/>

                                    </div>
                                    <div class="col-md-3">

                                        <f:input  path  ="quantity4" type="text"  class="form-control"/>

                                    </div>              
                                </div>
                                <div class="form-group row">
                                    <label for="first_name" class="col-md-2 card-header text-primary">Item 5</label>
                                    <div class="col-md-3">

                                        <f:input  path  ="item5" type="text"  class="form-control"/>

                                    </div>
                                    <div class="col-md-3">

                                        <f:input  path  ="quantity5" type="text"  class="form-control"/>

                                    </div> 

                                    <div class =" col-md-3">
                                        <button class=" btn-lg btn btn-primary"  type="submit">Save</button> 
                                    </div>
                                </div>
                            </f:form>



                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                      

                        <div class="tile">
                            <h4 class="tile-title text-info">Request Rejected By your Director</h4>      <div class="tile-body">
                           
                                   
                                <table class="table table-hover table-bordered" id="sampleTable">
                                    <thead>
                                        <tr>
                                            <th>Item 1</th>
                                            <th>Item 2</th>
                                            <th>Item 3</th>
                                            <th>Item 4</th>
                                            <th>Item 5</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var ="req" items ="${requests}">
                                            <tr> 
                                                <td class ="text-danger">${req.item1}</td>
                                                 <td class ="text-danger">${req.item2}</td>
                                                  <td class ="text-danger">${req.item3}</td>
                                                   <td class ="text-danger">${req.item4}</td>
                                                    <td class ="text-danger">${req.item5}</td>
                                    
                                            </tr>
                                        </c:forEach>


                                    </tbody>
                                </table>
                                      
                            </div>
                        </div>
                        
                                 <div class="tile">
                            <h4 class="tile-title text-info">Your Completed Request  </h4>      <div class="tile-body">
                           
                                   
                                <table class="table table-hover table-bordered" id="sampleTable">
                                    <thead>
                                        <tr>
                                            <th>Item 1</th>
                                            <th>Item 2</th>
                                            <th>Item 3</th>
                                            <th>Item 4</th>
                                            <th>Item 5</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var ="req" items ="${completedRequests}">
                                            <tr> 
                                                <td class ="text-danger">${req.item1}</td>
                                                 <td class ="text-danger">${req.item2}</td>
                                                  <td class ="text-danger">${req.item3}</td>
                                                   <td class ="text-danger">${req.item4}</td>
                                                    <td class ="text-danger">${req.item5}</td>
                                    
                                            </tr>
                                        </c:forEach>


                                    </tbody>
                                </table>
                                      
                            </div>
                        </div>
                        
                        
                        
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

