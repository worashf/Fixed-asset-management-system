<%-- 
    Document   : adminmaster
    Created on : May 9, 2019, 11:26:19 AM
    Author     : ewawuye
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Asset management- ${title}</title>
        <!-- Main CSS  -->
        <s:url var ="mainurl" value ="/resource/css/main.css"/>
        <link href="${mainurl}" rel="stylesheet" type="text/css"> 

        <!-- Custom CSS -->
        <s:url var ="customurl" value ="/resource/css/sb-admin-2.css"/>
        <link href="${customurl}" rel="stylesheet" type ="text/css">

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
                                <s:url var ="orgRegUrl" value ="/organization/organization_reg"/>
                                <li class =" nav-item font-weight-bold "><a  class ="nav-link active" href="${orgRegUrl}"><h5>Add Company</h5> </a>
                                    <s:url var ="departmenturl" value ="/dept/dept_add"/>

                                <li class="nav-item font-weight-bold mr-auto" ><a class ="nav-link" href="${departmenturl}"><h5>Manage Department</h5></a>
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
                                                    <h4>Companies</h4>
                                                    <p><b>1</b></p>
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
                                                <h4 class="tile-title"><s:message code ="label.organizationRegister"/></h4>
                                                <div class="tile-body">
                                                    <s:url var ="orgregurl"  value="/organization/org_registration"/>
                                                    <f:form action ="${orgregurl}" modelAttribute="orgcommand" method="POST">
                                                        <div class="form-row">
                                                            <s:message code ="label.organizationName" var="labelvalue"/>
                                                            <div class="form-group col-md-4">
                                                                <f:input path="organizationId" type="hidden"/>
                                                                <f:errors path="name" type ="text" cssClass="text-danger"/>
                                                                <f:input path ="name" type="text" class=" pt-3 form-control"  placeholder="${labelvalue}"/></br>
                                                                <f:errors path="phone" type ="text" cssClass="text-danger"/>
                                                                <f:input path ="phone" type="text" class="pt-3 form-control"  placeholder="Enter Organization phone"/></br>
                                                                <f:errors path="email" type ="text" cssClass="text-danger"/>
                                                                <f:input path="email"  type="text" class="pt-3 form-control"  placeholder="Enter Organization email"/></br>
                                                                <f:errors path="address" type ="text" cssClass="text-danger"/>
                                                                <f:input path ="address" type="text" class="pt-3  form-control"  placeholder="Enter organozation address"/>
                                                            </div>
                                                            <div class="form-group  col-md-4">
                                                                <f:errors path="city" type ="text" cssClass="text-danger"/>
                                                                <f:input path ="city" type="text" class=" pt-3 form-control"  placeholder="Enter organozation city"/></br>
                                                                <f:errors path="country" type ="text" cssClass="text-danger"/>
                                                                <f:input path ="country" type="text" class=" pt-3  form-control"  placeholder="Enter organozation country"/></br>
                                                                <f:input  path ="description" type="text" class="pt-3 form-control"  placeholder="Enter  description about organization"/></br>
                                                                <button class="ml-3 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Save Company</button>

                                                            </div>

                                                        </div>



                                                    </f:form>

                                                </div>


                                                <div class="tile">
                                                    <div class="tile-body">


                                                        <table class="table table-hover table-bordered" id="sampleTable">
                                                            <thead>
                                                                <tr>

                                                                    <th>Organization Name</th>
                                                                    <th> Organization Phone</th>
                                                                    <th> Organization Email</th>
                                                                    <th> Organization Address</th>

                                                                    <th> Organization Country</th>
                                                                    <th> Organization Description</th>
                                                                        <th>Action</th>
                                                                </tr>
                                                            </thead>

                                                            <tbody>
                                                                <c:forEach var ="o" items ="${organizationList}">
                                                                    <tr>
                                                                        <td>${o.name}</td>
                                                                        <td>${o.phone}</td>
                                                                        <td>${o.email}</td>
                                                                        <td>${o.address}</td>

                                                                        <td>${o.country}</td>
                                                                        <td>${o.description}</td>
                                                                        <s:url var="url_edit" value="/organization/orgEditGet">
                                                                            <s:param name="organizationId" value="${o.organizationId}"/>
                                                                        </s:url> 

                                                                        <s:url var="url_del" value="/organization/deleteOrganization">
                                                                            <s:param name="organizationId" value="${o.organizationId}"/>
                                                                        </s:url> 

                                                                        <td> 
                                                                            <a href="${url_edit}">Edit</a> 
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
