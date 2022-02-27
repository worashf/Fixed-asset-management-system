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
                                                     <s:url var ="role_url" value ="/security/role_page"/>
                                <s:url var="userregurl" value ="/security/user_page"/>
                                <s:url var="usermanageurl" value ="/security/user_manage"/>

                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${userregurl}"  ><h5>Add User</h5> </a>
                                </li>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${role_url}" ><h5>Manage Role</h5></a>
                                </li>
                                <li class=" nav-item font-weight-bold mr-auto" > <a class ="nav-link" href="${usermanageurl}" ><h5>Manage Users</h5></a>
                                </li>
                            </ul>

                           
                             

                              

                                    <!-- type of user -->
                                    <div class="row">

                                        <div class=" mt-3 col-md-6 col-lg-3">
                                            <div class="widget-small info coloured-icon"><i class="icon fa fa-star fa-4x"></i>
                                                <div class="info">
                                                    <h4>Roles</h4>
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

                                    </div>
                                     <!-- search user -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="tile">
                                        <h4 class="tile-title text-success">Register Role</h4>
                                        <div class="tile-body">
                                            <s:url var ="roleregurl" value ="/security/role_reg"/>
                                            <f:form action="${roleregurl}" moddelAtribute ="commad">
                                                <div class="form-row">

                                                    <div class="form-group col-md-4">
                                                    
                                                        <f:input type="text"  path ="name" class="form-control"  placeholder="new role name"/>
                                                        <f:errors type="text" path ="description" class ="text-primary" />

                                                    </div>
                                                    <div class="form-group col-md-4">
                                                      
                                                        <f:input path ="" class="form-control" placeholder="enter description" />
                                                    </div>
                                              
                                                <div class="form-group col-md-4">
                                                            <button class=" ml-3 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Save Role</button>
                                                     </div>
                                          </div>        </f:form>
                                             <div class="text-right">
                                                <a href ="#">Clear search</a>
                                              </div>

                                             </div>



                                    </div>
                                </div>
                            </div>
                <div class="tile">
                                <div class="tile-body">
                                    <table class="table table-hover table-bordered" id="sampleTable">
                                        <thead>
                                            <tr>
                                                
                                                <th>role name</th>
                                                 <th>description</th>
                                                 
                                                 <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var ="r" items ="${roleslist}">
                                                <tr>
                                                    <td>${r.name}</td>
                                                    <td>${r.description}</td>
                                        
                                   
                                    <s:url var="url_del" value="/security/deleteSytemRole">
                                        <s:param name="roleId" value="${r.roleId}"/>
                                    </s:url> 
                                  
                                   <td> 
                                       <a href="${url_del}">Delete</a>
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

