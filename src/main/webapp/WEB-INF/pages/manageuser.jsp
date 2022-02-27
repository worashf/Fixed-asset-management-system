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
        <!-- Custom CSS -->
        <s:url var ="styleurl" value ="/resource/css/style.css"/>
        <link href="${styleurl}" rel="stylesheet" type="text/css">

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
                                <h4 class="tile-title">Search employee </h4>
                                <div class="tile-body"> 
                                    <s:url var ="empsearchUrl"  value="/security/search_emp"/>
                                    <form action ="${empsearchUrl}" >
                                        <div class="form-row row ">

                                            <div class="form-group col-md-9 ">

                                                <div class="form-row">

                                                    <div class="form-group col-md-3">

                                                        <input name ="firstName" type="text" class="form-control"  placeholder="Enter First name"/>

                                                    </div>
                                                    <div class="form-group col-md-3">

                                                        <input name ="middleName" type="text" class="form-control"  placeholder="Enter Middle name"/>

                                                    </div>
                                                    <div class="form-group col-md-3">

                                                        <input name ="lastName" type="text" class="form-control"  placeholder="Enter last name"/>

                                                    </div>

                                                </div>
                                            </div>
                                            <div class ="col-md-3">
                                                <button class="btn btn-primary"  type="submit"><i class=" "></i>Search</button>
                                            </div>
                                        </div>

                                    </form>
                                    <div class="tile">
                                        <div class="tile-body">
                                            <table class="table table-hover table-bordered" id="sampleTable">
                                                <thead>
                                                    <tr>

                                                        <th>First Name</th>
                                                        <th>Middle Name</th>
                                                        <th>Last Name</th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach items="${empList}" var ="emp">
                                                        <tr>
                                                            <td> ${emp.firstName}</td>
                                                            <td>  ${emp.middleName}</td>
                                                            <td> ${emp.lastName}</td>
                                                            <s:url var="url_emp" value="/security/user_with_emp">
                                                                <s:param name="employeeId" value="${emp.employeeId}"/>
                                                            </s:url> 



                                                            <td> 
                                                                <a href="${url_emp}">Select</a> 
                                                            </td>
                                                        </tr>
                                                    </c:forEach>


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>



                                </div>
                            </div>


                            <div class="tile">
                                <h4 class="tile-title">Register User</h4>
                                <div class="tile-body">
                                    <s:url var ="userRegUrl"  value="/security/user_reg"/>

                                    <div class="row ">

                                        <div class=" col-md-6">
                                            <f:form action ="${userRegUrl}" modelAttribute ="user"  method="POST">
                                                <input  type="hidden" name="employeeId"  value="${employeeId}"/>
                                                <div class="card">
                                                    <div class="card-header">User Information</div>
                                                    <div class="card-body">
                                                        <div class="form-group row">
                                                            <label for="username" class="col-md-4 col-form-label text-md-left">User name</label>
                                                            <div class="col-md-8">
                                                                <f:errors path = "username"  class ="text-danger"/>
                                                                <f:input path ="username" type="text"  class="form-control"/>
                                                            </div>
                                                        </div>


                                                        <div class="form-group row">
                                                            <label for="password" class="col-md-4 col-form-label text-md-left">Password</label>
                                                            <div class="col-md-8">
                                                                <f:errors path = "password"  class ="text-danger"/>
                                                                <f:input path ="password" type="text"  class="form-control"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label for="confirmpassword" class="col-md-4 text-primary col-form-label text-md-left">Confirm password</label>
                                                            <div class="col-md-8">
                                                                <f:errors path = "confirmPassword"  class ="text-danger"/>
                                                                <f:input path ="confirmPassword" type="text"  class="form-control"/>
                                                            </div>
                                                        </div>


                                                        <div style="margin-top:10px" class="col-xs-6 col-sm-6 col-md-6">
                                                            <div class="form-check">
                                                                <input class="form-check-input" type="radio" name="role" id="personal" value="PERSONAL" checked>
                                                                <label class="form-check-label" for="librarian">
                                                                    Personal user
                                                                </label>
                                                            </div>
                                                            <div class="form-check">
                                                                <input class="form-check-input" type="radio" name="role" id="admin" value="ADMIN">
                                                                <label class="form-check-label" for="admin">
                                                                    Admin user
                                                                </label>
                                                            </div>
                                                            <div class="form-check">
                                                                <input class="form-check-input" type="radio" name="role" id="kepeer" value="KEPEER">
                                                                <label class="form-check-label" for="admin">
                                                                    Store kepeer user
                                                                </label>
                                                            </div>
                                                            <div class="form-check">
                                                                <input class="form-check-input" type="radio" name="role" id="directer" value="DIRECTER">
                                                                <label class="form-check-label" for="admin">
                                                                    Directer user
                                                                </label>
                                                            </div>
                                                            <div class="form-check">
                                                                <input class="form-check-input" type="radio" name="role" id="manager" value="MANAGER">
                                                                <label class=" form-check-label" for="admin">
                                                                    Manager user
                                                                </label>
                                                            </div>
                                                        </div>


                                                    </div> <%-- registration card  end --%>
                                                    <div class ="ml-5 mb-5 col-md-3">
                                                        <button class=" btn-lg btn btn-primary"  type="submit">Save</button> 
                                                    </div>

                                                </div>



                                            </f:form>       





                                        </div>
                                        <div class=" col-md-6">
                                             <div class="card">
                                                    <div class="card-header">Employee Information</div>
                                                    <div class="card-body">
                                                 <div class="form-row">

                                                    <div class="form-group col-md-4">

                                                        <input  value ="${firstName}" type="text" class="form-control"  readonly/>

                                                    </div>
                                                    <div class="form-group col-md-4">

                                                        <input   value ="${middleName}" type="text" class="form-control"   readonly/>

                                                    </div>
                                                    <div class="form-group col-md-4">

                                                        <input  value ="${lastName}" type="text" class="form-control"  readonly/>

                                                    </div>

                                                </div>
                                        </div>
                                                                </div>

                                                </div>
                                        </div>



                                    </div>

                                </div> 




                                <%-- buton --%>     
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

    <s:url var="urlcalendar" value="/resource/js/plugin/fullcalendar.min.js" />


    <script type="text/javascript" src="${urlcalendar}"></script>
    <script type="text/javascript">$('#sampleTable').DataTable();</script>


</body>
</html>

