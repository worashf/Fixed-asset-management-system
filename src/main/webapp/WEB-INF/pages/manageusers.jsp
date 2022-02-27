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



                            <%-- asset search start --%>
                            <div class="tile">
                                <h4 class="tile-title">Search User </h4>
                                <div class="tile-body"> 
                                    <s:url var ="employeeSearchUrl"  value="/employee/searchEmpbyName"/>
                                    <form action ="${emplyeeSearchUrl}">
                                        <div class="form-row row ">

                                            <div class="form-group col-md-6 ">

                                                <input  type="text" name ="searchCode" class="form-control"  placeholder="Enter employee code to search"/>

                                            </div>
                                            <div class ="col-md-3">
                                                <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Search</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>


                     
                        </div>                



     <%-- table body--%>
                            <div class="tile">
                                <div class="tile-body">


                                    <table class="table table-hover table-bordered" id ="samleTable" >
                                        <thead>
                                            <tr>


                                                <th>User Name</th>
                                                  <th> Status</th>
                                                  <th>Action</th>
                                            
                                               

                                      
                                                 



                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var ="user" items = "${userList}">
                                                <tr >
                                                    <td>${user.username}</td>
                                                       
                                                    <td>${user.enable}</td>
                                                       

                                               
                                                   

                                                    <td>
                                                        <s:url var="disableUser" value="/security/disable_user">
                                                        <s:param name="userId" value="${user.userId}"/>
                                                        </s:url>
                                                         <s:url var="enableUser" value="/security/enable_user">
                                                        <s:param name="userId" value="${user.userId}"/>
                                                        </s:url>
                                                        <c:if test ="${user.enable == true}">
                                                         <a  class ="nav-item" href="${disableUser}">Disable</a> 
                                                        </c:if>
                                                           <c:if test ="${user.enable == false}">
                                                         <a  class ="nav-item" href="${enableUser}">Enable</a> 
                                                        </c:if>
                                                      
                                                    </td>
                                                     
                                                </tr>
                                         
                                                    <c:forEach var ="role" items = "${user.roles}">
                                                       <tr>   
                                                          <td>        
                                                                                 <label class=" text-primary mr-4">Role Name:</label><label class=" text-primary ">${role.name}</label>
                                                              </td>
                                                 
                                                          </tr>
                                                       </c:forEach>
                                              

                                            </c:forEach>

                                        </tbody>
                                    </table>

                                </div>

                             
                            </div>  <%-- table end --%>



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

    <s:url var="urlcalendar" value="/resource/js/plugin/fullcalendar.min.js" />


    <script type="text/javascript" src="${urlcalendar}"></script>
    <script type="text/javascript">$('#sampleTable').DataTable();</script>


</body>
</html>

