<%-- 
    Document   : departmentlist
    Created on : Jul 10, 2019, 5:08:17 AM
    Author     : ewawuye
--%>

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
        <link href="${customurl}" rel="stylesheet" type="text/css"/> 

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
                            <ul class="nav nav-tabs">
                                <s:url var ="orgRegUrl" value ="/organization/organization_reg"/>
                                <li class =" nav-item  font-weight-bold"><a  class ="nav-link " href="${orgRegUrl}"><h5>Add Company</h5> </a></li>
                                    <s:url var ="departmenturl" value ="/dept/dept_add"/>
                                    <s:url var ="departmetlisturl" value ="/dept/listDepatment"/>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${departmenturl}"><h5>Department</h5></a>
                                </li>

                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${departmetlisturl}"><h5>Department  list</h5></a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane tab-pane fade show active" id="home-pills">



                                    <!-- type of user -->
                                    <div class="row">

                                        <div class="mt-5 col-md-6 col-lg-3">
                                            <div class="widget-small info coloured-icon"><i class="icon fa fa-star fa-4x"></i>
                                                <div class="info">
                                                    <h>Departments</h4>
                                                        <p><b>500</b></p>
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
                                                <div class="tile-body">


                                                    <table class="table table-hover table-bordered" id="sampleTable">
                                                        <thead>
                                                            <tr>

                                                                <th>Department Name</th>
                                                                <th> Department Phone</th>
                                                                <th> Department Email</th>

                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <c:forEach var ="dept" items ="${deptList}">
                                                                <tr>
                                                                    <td>      ${ dept.name  }              </td> 
                                                                    <td>      ${ dept.phone  }              </td> 
                                                                    <td>      ${ dept.email  }              </td> 
                                                                    <s:url var="url_edit" value="/dept/deptEditGet">
                                                                        <s:param name="departmentId" value="${dept.departmentId}"/>
                                                                    </s:url> 

                                                                    <s:url var="url_del" value="/dept//deleteDepatment">
                                                                        <s:param name="departmentId" value="${dept.departmentId}"/>
                                                                    </s:url> 

                                                                    <td> 
                                                                        <a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>

                                                        </tbody>
                                                    </table>

                                                </div>
                                            </div> 


                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->

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
