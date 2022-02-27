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
        <%@include file="./shared/header.jsp"%>
        <!-- Side Navigation -->
        <%@include file="./shared/leftside.jsp"%>



        <main class="app-content">

            <div class="row">
                <div class="col-md-12">



                    <div class="panel panel-default">

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs --> 
                            <s:url var ="assetFinanceInfourl" value ="/storeKeper/asset_financeInfo"/>
                            <s:url var ="assetWarrantyurl" value ="/asset_warranty"/>
                            <s:url var ="assetmaintanaceInfourl" value ="/storeKeper/maintenanceInfo"/>

                            <ul class="nav ">
                                <li class =" nav-item "><a  class ="nav-link active" href="${assetWarrantyurl}" >Warranty  </a>
                                </li>
                                <li class="nav-item" ><a class ="nav-link" href=" ${assetFinanceInfourl}"  >Finance information</a>
                                </li>
                                <li class=" nav-item" > <a class ="nav-link" href="${assetmaintanaceInfourl}" >Maintenance Information</a>
                                </li>
                                <li class=" nav-item" > <a class ="nav-link" href="#" >Service Information</a>
                                </li>
                            </ul>






                            <!-- search user -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="tile">
                                        <h4 class="tile-title">Search asset </h4>
                                        <div class="tile-body">
                                            <form>
                                                <div class="form-row">

                                                    <div class="form-group col-md-3">

                                                        <input type="text" class="form-control"  placeholder="Search by asset name">
                                                    </div>
                                                    <div class="form-group col-md-3">

                                                        <input type="text" class="form-control"  placeholder="Search by asset code">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <input type="email" class="form-control"  placeholder="Search by asset brand">
                                                    </div>
                                                    <div class="form-group col-md-3">

                                                        <input type="text" class="form-control"  placeholder="Search by asset model">
                                                    </div>
                                                </div>
                                                <div class="form-row">

                                           

                                                    <div class="form-group col-md-3">
                                                        <select    type ="text" class ="form-control">

                                                            <option value="male" label="Male">
                                                            <option value="female" label="Female">


                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-3">

                                                        <select    type ="text" class ="form-control">

                                                            <option value="male" label="Male">
                                                            <option value="female" label="Female">


                                                        </select>
                                                    </div> 
                                                    <div class="form-group col-md-3">

                                                        <select    type ="text" class ="form-control">

                                                            <option value="assttype" label="Male">



                                                        </select>
                                                    </div>
                                                     <div class="form-group col-md-3">
                                                      <div class="form-group col-md-4 text-right">
                                                        <div class="form-group purple-border">
                                                            <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Search asset</button>
                                                        </div>
                                                    </div> 
                                                          </div> 
                                                </div>
                                                
                                                    

                                                   
                                            </form>


                                     
                                    </div>


                                </div>
                          <%-- table body--%>
                       <div class="tile">
                <div class="tile-body">
                 
                  
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                            <tr>
                                
                                <th>Organization Name</th>
                                <th> Organization Phone</th>
                                 <th> Organization Email</th>
                                 <th> Organization Address</th>
                                 <th> Organization City</th>
                                 <th> Organization Country</th>
                                 <th> Organization Description</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var ="o" items ="${organizationlists}">
                                <tr>
                                    <td>${o.name}</td>
                                    <td>${o.phone}</td>
                                    <td>${o.email}</td>
                                    <td>${o.address}</td>
                                    <td>${o.city}</td>
                                    <td>${o.country}</td>
                                    <td>${o.description}</td>
                                   <s:url var="url_edit" value="/user/edit_catagory">
                                        <s:param name="cid" value="${o.organizationId}"/>
                                    </s:url> 
                                   
                                    <s:url var="url_del" value="/user/delete_catagory">
                                        <s:param name="cid" value="${o.organizationId}"/>
                                    </s:url> 
                                   <s:url var="adddepartmenturl" value="/ddepartment/add" >
                                       <s:param name="organizationId" value="${o.organizationId}"/>
                                   </s:url>
                                   <td> 
                                       <a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a>| <a href="${adddepartmenturl}">Add department</a>
                                   </td>
                                </tr>
                            </c:forEach>

                                
                        </tbody>
                    </table>
                  
                </div>
            </div>  <%-- table end --%>
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


