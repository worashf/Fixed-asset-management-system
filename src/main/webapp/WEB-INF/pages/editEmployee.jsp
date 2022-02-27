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





                            <s:url var="employeeurl1" value ="/employee/add"/>
                             
                            <ul class="nav navbar-light bg-light ">

                                <li class =" nav-item font-weight-bold "><a  class =" nav-link mr-3" href="${employeeurl1}"><h5>Add Employee</h5> </a></li>

                                    <s:url var ="empMnageUrl" value ="/manage/empManage"/>
                                     <s:url var ="empSearchUrl" value ="/employee/searchEmp"/>

                                <li class="nav-item font-weight-bold" ><a class =" nav-link" href="${empMnageUrl}"><h5>Manage Employee</h5></a>
                                </li>
                         
                            </ul>







                                    <!-- search user -->
                                    <div class="row">
                                        <div class="col-md-12">
                                         
                                            <div class="tile">
                                                <h4 class="tile-title">Edit  Employee</h4>
                                                <div class="tile-body">
                                                    <s:url var ="employeeeditUrl"  value="/employee/emp_edit"/>
                                                    <f:form action ="${employeeeditUrl}" modelAttribute ="employee"  method="POST">
                                                        <div class="form-row">
                                                            <div class="form-group col-md-5">


                                                                <div class="card">
                                                                    <div class="card-header">Employee Personal Information</div>
                                                                    <div class="card-body">

                                                                        <div class="form-group row">
                                                                            <f:input path="employeeId" type="hidden"/>
                                                                            <label for="first_name" class="col-md-4 col-form-label text-md-left"><s:message code ="label.firstName"/></label>
                                                                            <div class="col-md-8">
                                                                              
                                                                                <f:input path ="firstName" type="text"  class="form-control"/>
                                                                                
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-group row">
                                                                            <label for="middle_name" class="col-md-4 col-form-label text-md-left"><s:message code ="label.middleName"/></label>
                                                                            <div class="col-md-8">
                                                                                
                                                                                <f:input path ="middleName" type="text"  class="form-control" />
                                                                               
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-group row">
                                                                            <label for="last_name" class="col-md-4 col-form-label text-md-left"><s:message code ="label.lastName"/></label>
                                                                            <div class="col-md-8">
                                                                               
                                                                                <f:input path ="lastName" type="text"  class="form-control" />
                                                                            </div>
                                                                        </div>
                                                                              <div class="form-group row">
                                                                            <label for="age" class="col-md-4 col-form-label text-md-left">Employee Code</label>
                                                                            <div class="col-md-8">
                                                                                
                                                                                <f:input path ="code" type="text"  class="form-control"/>
                                                                            </div>
                                                                        </div>


                                                                        <div class="form-group row">
                                                                            <label for="age" class="col-md-4 col-form-label text-md-left">Age</label>
                                                                            <div class="col-md-8">
                                                                                <f:input path ="age" type="text"  class="form-control"/>
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-group row">
                                                                            <label for="phone_number" class="col-md-4 col-form-label text-md-left">Phone Number</label>
                                                                            <div class="col-md-8">
                                                                                <f:input path ="phone" type="text"  class="form-control"/>
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-group row">
                                                                            <label for="email" class="col-md-4 col-form-label text-md-left">Email Address</label>
                                                                            <div class="col-md-8">
                                                                        
                                                                                <f:input path ="email" type="text"  class="form-control" />
                                                                     
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-group row">
                                                                            <label for="gender" class="col-md-4 col-form-label text-md-left"> Gender</label>
                                                                            <div class="col-md-8">
                                                                                <f:select  path ="gender"  class ="form-control">

                                                                                    <f:option value="male" label="Male"/>
                                                                                    <f:option value="female" label="Female"/>


                                                                                </f:select>
                                                                            </div>
                                                                        </div>


                                                                    </div> <%-- registration card  end --%>


                                                                </div>
                                                            </div>

                                                            <div class=" col-md-4">
                                                                <div class="form-group row">

                                                                    <label class="col-md-4 col-form-label text-md-left">Select Department</label>

                                                                    <%--   <input type="text"   value ="${command}" class="form-control"  /> 
                                                                
                                                                    <input type ="text" value="${organizationId}"/>   --%> 
                                                                    <div class="col-md-8">
                                                                        <f:select  path ="department.departmentId"  class ="form-control">

                                                                            <f:options items="${departments}" itemLabel ="name" itemValue ="departmentId"/>


                                                                        </f:select>
                                                                    </div> 
                                                                </div>
                                                                <div class="form-group row">
                                                                    <label for="job_position" class="col-md-4 col-form-label text-md-left"> Job Position</label>
                                                                    <div class="col-md-8">
                                                                                   <f:errors path ="jobPosition" type ="text" cssClass="text-danger"/>
                                                                        <f:input path ="jobPosition" type="text" id="nid_number" class="form-control"/>
                                                                    </div>
                                                                     <div class="col text-center">
                                                                             <button class="mt-5 ml-3 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Save Employee</button>
                                                                                </div>
                                                            </div> 
                                                                </div>

                                                            </div>      

       
                                                        </f:form>
       

                                                        <%-- buton --%>     
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

