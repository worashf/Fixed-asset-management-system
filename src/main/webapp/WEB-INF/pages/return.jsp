<%--
  Created by IntelliJ IDEA.
  User: uppert
  Date: 10/21/2019
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
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
    <s:url var ="styleurl" value ="/resource/css/bootstrap.min"/>
    <link href="${styleurl}" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <s:url var ="customurl" value ="/resource/css/sb-admin-2.css"/>
    <link href="${customurl}" rel="stylesheet" type="text/css">

    <!-- font awasome -->
    <s:url var ="fonturl" value ="/resource/css/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link href= "${fonturl}" rel="stylesheet" type="text/css"/>
        <s:url var ="bootstrappickerurl" value ="/resource/assets/css/bootstrap-datepicker.css"/>

        <link href="${bootstrappickerurl}" rel="stylesheet" type="text/css"/>

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
                    <ul class="nav navbar bg-light">

                        <s:url var ="manageasseturl" value ="/warranty/warranty_page"/>
                        <s:url var="assetregurl" value ="/asset/asset_reg"/>
                        <s:url var ="assetFinanceInfourl" value ="/financeInfo/financeInfo_page"/>
                        <s:url var ="assetAssignmenturl" value ="/asset/assignPage"/>
                        <s:url var ="AssignedAsseturl" value ="/asset/showAssignedAssets?pageNo=1"/>
                        <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${assetregurl}" ><h5>Add Asset</h5></a>
                        </li>
                        <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${manageasseturl}"  ><h5>Add Warranty</h5> </a>
                        </li>
                        <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${assetFinanceInfourl}" ><h5>Finance Information</h5></a>
                        </li>
                        <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${assetAssignmenturl}" ><h5>Assign Assets</h5></a>
                        </li>
                        <li class=" nav-item font-weight-bold " > <a class ="nav-link" href="${AssignedAsseturl}" ><h5>Show Assigned</h5></a>
                        </li>
                        <s:url var ="EmpassetAssignmenturl" value ="/asset/search_empPage"/>
                        <li class=" nav-item font-weight-bold  mr-auto" > <a class ="nav-link" href="${EmpassetAssignmenturl}" ><h5>Employee Assets</h5></a>
                        </li>
                    </ul>


                    <!-- search user -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="tile">
                                <h4 class="tile-title text-primary">Return asset </h4>
                                <c:if test="${param.act eq 'assigned'}">
                                    <p class="text-success"> Asset assigned Successfully</p>
                                </c:if>
                                <c:if test="${param.act eq 'error'}">
                                    <p class="text-danger"> This Asset is already  assigned</p>
                                </c:if>
                                <c:if test="${message!=null}">
                                    <p class="text-danger">${message}</p>
                                </c:if>
                                <s:url  var ="returnUrl" value="/asset/returnAssignedAssets"/>
                                <div class="tile-body">
                                    <f:form action ="${returnUrl}" modelAtribute ="command" method="POST">
                                        <div class="form-row">
                                            <input name="assignedId" type="hidden" value="${param.assignedId}"  />


                                            <input name="employeeId" type="hidden"  value="${param.employeeId}"  />
                                            <div class="form-group col-md-6">

                                                <div class="form-group row">
                                                    <label for="comment" class="label-bold text-lg-left text-primary  control-label col-md-4 col-form-label text-md-left ml-2">Comment</label>
                                                    <div class="form-group col-md-6">
                                                        <f:textarea path ="comment" class="form-control"  rows="2" placeholder="Enter your comment"/>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="asset_code" class="label-bold text-lg-left text-primary  col-md-4 col-form-label text-md-left ml-2">Return Date</label>
                                                    <div class="form-group col-md-6">
                                                        <f:input path="addDate" type="text"   class="datepicker form-control" placeholder="Select return date"/>
                                                        <f:errors path="addDate" class="text-danger"/>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="employee_code" class="label-bold text-lg-left text-primary  col-md-4 col-form-label text-md-left ml-2">Employee Code</label>
                                                    <div class="form-group col-md-6">
                                                        <input name="employeeCode" type="text" value="${param.employeeCode}"  class="form-control" readonly/>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="asset code" class="label-bold text-lg-left text-primary col-md-4 col-form-label text-md-left ml-2">Asset Code</label>
                                                    <div class="form-group col-md-6">
                                                        <input name="assetCode" type="text" value="${param.assetCode}"  class="form-control" readonly/>
                                                    </div>
                                                </div>





                                                <button class="mt-5 ml-5 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Return asset</button>


                                            </div>

                                        </div>










                                    </f:form>



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

<s:url var ="jquerypickerurl" value ="/resource/assets/js/jquery-1.10.2.js"/>
    <script src="${jquerypickerurl}" type="text/javascript"></script>
    <s:url var ="bootstrapjsurl" value ="/resource/assets/js/bootstrap.js"/>
    <script src="${bootstrapjsurl}" type="text/javascript"></script>
    <s:url var ="bootstrapjspickerurl" value ="/resource/assets/js/bootstrap-datepicker.js"/>
    <script src="${bootstrapjspickerurl}" type="text/javascript"></script>
    <script type="text/javascript">
        $('.datepicker').datepicker({
            weekStart:1,
            color: 'red'
        });
    </script>

</body>
</html>





