<%-- 
    Document   : SearchEmpByName
    Created on : Sep 24, 2020, 9:38:55 PM
    Author     : uppert
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





                        
                            <ul class="nav navbar-light bg-light ">
                                   <s:url var ="employeeurl" value ="/employee/add"/> 
                                <li class =" nav-item font-weight-bold"><a  class =" nav-link mr-3" href="${employeeurl}"><h5>Add Employee</h5> </a>
                                </li>
                                   <s:url var ="empMnageUrl" value ="/manage/empManage"/>
                                       <s:url var ="employeeSerchUrl" value ="/manage/search-employee"/> 

                                <li class="nav-item font-weight-bold" ><a class =" nav-link" href="${empMnageUrl}"><h5>Manage Employee</h5></a>
                                </li>
                                   <li class="nav-item font-weight-bold" ><a class =" nav-link" href="${employeeSerchUrl}"><h5>Search Employee</h5></a>
                                </li>
                               
                            </ul>

   <c:if test ="${param.act eq 'emp_edit'}">
                                            <h5 class="font-weight-bold ml-5 mt-5 text-success">Employee successfully Updated!</h5>
                                        </c:if>

                                  <c:if test="${message!=null}">
                                            <h2 class="text-danger">${message}</h2>
                                       </c:if> 


                                    <!-- search user -->
                                    <div class="row">
                                        <div class="col-md-12">
                             
                                            
                                                
                                                
                                                
                           
                                    <!-- start search by name-->
                                                
                                                       <%-- search field  body--%>
                                   <s:url var ="empsearchUrl1"  value="/manage/search_emp1"/>
                                
                                   <div class="tile">
                                        <h4 class="tile-title">Search employee  </h4>
                                             <c:if test="${message!=null}">
                                            <h2 class="text-danger">${message}</h2>
                                       </c:if> 
                                   <div class="tile-body"> 
                             <form action ="${empsearchUrl1}" method="get">
                            <div class=" panel-body form-row ml-5">
                           
                                <div class="form-group col-md-3">
                           <input name ="firstName" type="text"  class="form-control"  placeholder="Enter First name"/> 
                                </div>
                               
                                <div class="form-group col-md-3">

                                    <input type="text"  name ="middleName"   class="form-control"  placeholder="Enter Middles name .."/>


                                </div>
                                <div class="form-group col-md-3">

                                    <input type="text" name="lastName"   class="form-control"  placeholder="Enter Last name .."/>
                                </div>
                               
                                <div class="form-group col-md-3">
                                    <button class="ml-3 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Search</button>
                                </div>
                                
                            </div> 
                            </form>         
                          </div> 
                      </div>
               
                     
                            <!-- -->
                              
                                                  <div class="tile">
                                        <div class="tile-body">
                                            <table class="table table-hover table-bordered" id="sampleTable">
                                                <thead>
                                                    <tr>

                                                       <th>First Name</th>
                                                                    <th> Middle Name</th>
                                                                    <th> Last Name</th>
                                                                    <th>  Email</th>
                                                                     <th> age</th>
                                                                  
                                                                    <th> Employee code</th>
                                                                     <th>Action</th>

                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach items="${emp}" var ="e">
                                                        <tr>
                                                            <td>${e.firstName}</td>
                                                                     <td>${e.middleName}</td>
                                                                      <td>${e.lastName}</td>
                                                                      <td>${e.email}</td>
                                                                      <td>${e.age}</td>
                                                                      <td>${e.code}</td>
                                        <s:url var="employeeEditUrl1" value="/manage/empEditGet" >
                                       <s:param name="employeeId" value="${e.employeeId}"/>
                                        </s:url>
                                           <s:url var="employeeDeleteUrl1" value="/employee/deleteEmployee">
                                       <s:param name="employeeId" value="${e.employeeId}"/>
                                        </s:url>
                                       
                                        
                                   <td> 
                                       <a  class ="nav-item" href="${employeeEditUrl1}">Edit Employee</a> 
                                   </td>
                                     <td> 
                                       <a  class ="nav-item" href="${employeeDeleteUrl1}">Delete Employee</a> 
                                   </td>
                                                    
                                                        </tr>
                                                    </c:forEach>


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                              
                                    
                            <!-- -->
                                 
                                   
                                   

                                        
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


