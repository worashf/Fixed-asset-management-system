<%--
    Document   : assetHistory
    Created on : Sep 4, 2019, 3:28:42 AM
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
                        <s:url var ="manageasseturl" value ="/warranty/warranty_page"/>
                        <s:url var="assetregurl" value ="/asset/asset_reg"/>
                      
                        <s:url var ="assetAssignmenturl" value ="/asset/assignPage"/>
                        <s:url var ="AssignedAsseturl" value ="/asset/showAssignedAssets?pageNo=1"/>
                        <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${assetregurl}" ><h5>Add Asset</h5></a>
                        </li>
                        <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${manageasseturl}"  ><h5>Add Warranty</h5> </a>
                        </li>
                     
                        <li class=" nav-item  font-weight-bold" > <a class ="nav-link" href="${assetAssignmenturl}" ><h5>Assign Assets</h5></a>
                        </li>
                        <li class=" nav-item font-weight-bold " > <a class ="nav-link" href="${AssignedAsseturl}" ><h5>Show Assigned</h5></a>
                        </li>
                        <s:url var ="EmpassetAssignmenturl" value ="/asset/search_empPage"/>
                        <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${EmpassetAssignmenturl}" ><h5>Employee Assets</h5></a>
                        </li>
                        <s:url var ="historyurl" value ="/asset/assetHistoryPage?pageNo=1"/>
                        <li class="nav-item font-weight-bold mr-auto" > <a class ="nav-link" href="${historyurl}" ><h5>Asset History</h5>
                        </a>
                        </li>
                    </ul>






                    <!-- type of user -->
                    <div class="row">





                        <div class=" mt-3 col-md-6 ">
                            <div class="widget-small info coloured-icon"><i class="icon fa fa-shopping-cart"></i>
                                <div class="info">
                                    <h4> Assets History Count</h4>
                                    <p><b>${resultsCount}</b></p>
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

                        </div>
                        <c:if test="${message!=null}">
                            <h3 class= " font-italic font-weight-bold text-danger">${message}</h3>
                        </c:if>
                    </div>
                    <div class="row form-row">
                        <div class="col-md-6">
                    <%-- search field  body--%>
                    <s:url var ="SearchAssetHistoryUrl"  value="/asset/searchAssetHistory"/>
                    <f:form action ="${SearchAssetHistoryUrl}" modelAttribute="catagory"  method ="get">


                        <div class="form-group row">


                          <label class ="text-primary font-italic label-bold control-label font-weight-bold col-md-3 col-form-label">Search By Category</label>
                            <input type="hidden" name="pageNo" value=1>

                        <div class="form-group col-6">
                                <f:select path ="catagoryId"   type ="text" class ="form-control">

                                    <f:options items="${catagorylist}" itemLabel ="catagoryName" itemValue ="catagoryId"/>



                                </f:select>
                        </div>


                            <div class="form-group col-3">
                                <button class="btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Search</button>

                            </div>

                        </div>
                    </f:form>
                        </div>
                        <div class=" col-md-6">
<s:url var ="SearchAssetHistoryByAssetCodeUrl"  value="/asset/searchAssetHistoryByAssetCode"/>
<f:form action ="${SearchAssetHistoryByAssetCodeUrl}" modelAttribute="catagory"  method ="get">

    <div class="form-group row">


        <label class ="text-primary font-italic label-bold control-label font-weight-bold col-md-3 col-form-label">Search by asset code</label>
        <input type="hidden" name="pageNo" value=1>

        <div class="form-group col-6">
                            <input name="assetCode" type="text" class="form-control" placeholder="Enter asset code to search "/>
                            </div>
        <div class="form-group col-3">
        <button class="ml-3 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Search</button>

                            </div>
    </div>
</f:form>
                        </div>
                    </div>
                    <%-- table body--%>
                    <div class="tile">
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
                                    <th> Comment</th>
                                    <th> return  Date</th>





                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var ="assetHistory" items = "${assetHistory}">
                                    <tr>
                                        <td>${assetHistory.employee.firstName}</td>
                                        <td>${assetHistory.employee.middleName}</td>
                                        <td>${assetHistory.employee.lastName}</td>
                                        <td>${assetHistory.employee.code}</td>
                                        <td>${assetHistory.employee.jobPosition}</td>
                                        <td>${assetHistory.employee.department.name}</td>

                                        <td>${assetHistory.asset.assetCode}</td>

                                        <td>${assetHistory.asset.catagory.catagoryName}</td>
                                        <td>${assetHistory.asset.brand}</td>
                                        <td>${assetHistory.comment} </td>
                                        <td>${assetHistory.addDate}</td>


                                            <%--

                                     <td>
                                          <s:url var="returnAssignAsset" value="/asset/returnAssignedAssets">
                                         <s:param name="assignedId" value="${assignedAsset.id}"/>
                                          <s:param name="employeeId" value="${assignedAsset.employee.employeeId}"/>
                                     </s:url>
                                         <a  class ="nav-item" href="${returnAssignAsset}">Return</a>
                                     </td>
                                         --%>
                                    </tr>

                                </c:forEach>

                                </tbody>
                            </table>

                        </div>

                        <!-- data  Navigation -->
                        <div class ="ml-5">
                            <%@include file="./shared/assetHistoryNavigation.jsp"%>
                        </div>
                    </div>  <%-- table end --%>

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
<%--
<s:url var="urlboottable" value="/resource/js/plugin/dataTables.bootstrap.min.js" />
<s:url var="urlcalendar" value="/resource/js/plugin/fullcalendar.min.js" />
<script type="text/javascript" src="${urltable}"></script>
<script type="text/javascript" src="${urlboottable}"></script>
<script type="text/javascript" src="${urlcalendar}"></script>
        --%>
<script type="text/javascript">$('#samleTable').DataTable();</script>

</body>
</html>

