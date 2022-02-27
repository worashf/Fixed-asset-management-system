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
        <s:url var ="customurl" value ="/resource/css/custom"/>
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






                            <ul class="nav navbar-light bg-light nav-tabs">
                                   <s:url var ="employeeurl" value ="/add"/> 
                                <li class =" nav-item font-weight-bold"><a  class =" nav-link mr-3" href="${employeeurl}"><h5>Add Employee</h5> </a>

                                   <s:url var ="empMnageUrl" value ="/empManage"/>

                                <li class="nav-item font-weight-bold" ><a class =" nav-link" href="${empMnageUrl}"><h5>Manage Employee</h5></a>
                                </li>
                                   <s:url var ="employeeSerchUrl" value ="/manage/search-employee"/> 
                                  <li class="nav-item font-weight-bold" ><a class =" nav-link" href="${employeeSerchUrl}"><h5>Search Employee</h5></a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content mt-5">
                                <div class="tab-pane tab-pane fade show active" id="home-pills">




                                    <!-- search user -->
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="tile">
                                                <h4 class="tile-title">Register Employee</h4>
                                              
                                                             <%-- asset search start --%>
                                     <div class="tile">
                                        <h4 class="tile-title">Search employee </h4>
                                        <div class="tile-body"> 
                                            <s:url var ="employeeSearchUrl"  value="/employee/searchEmpbyName"/>
                                            <form action ="${emplyeeSearchUrl}" method="get">
                                                <div class="form-row">

                                                    <div class="form-group col-md-3">
 
                                                        <input  type="text" name ="fname" value="${param.fname}" class="form-control"  placeholder="search"/>
                                                    </div>
                                                 
                                                </div>
                                                
                                                    
                                                        <div class="form-group purple-border">
                                                            <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Search</button>
                                                        </div>
                                               
                                                   
                                            </form>

   
                                 
                                        </div>
                                </div>
                                                    
                                                <div class="tile">
                                                    <div class="tile-body">


                                                        <table class="table table-hover table-bordered" id="sampleTable">
                                                            <thead>
                                                                <tr>
                                                                 ${emp1}
                                                                    <th>First Name</th>
                                                                    <th> Middle Name</th>
                                                                    <th> Last Name</th>
                                                                    <th>  Email</th>
                                                                     <th> age</th>
                                                                  
                                                                     <th> Employee code</th>
                                                                   
                                                                </tr>
                                                            </thead>

                                                            <tbody> 
                                                               
                                                                <c:forEach items="${emp1}" var="emp1">   
                                                                <tr>
                                                                    <td>${emp1.firstName}</td>
                                                                     <td>${emp1.middleName}</td>
                                                                      <td>${emp1.lastName}</td>
                                                                      <td>${emp1.email}</td>
                                                                      <td>${emp1.age}</td>
                                                                      <td>${emp1.code}</td>
                                                                      
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


