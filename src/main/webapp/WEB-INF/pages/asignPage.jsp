<%-- 
    Document   : asignPage
    Created on : Sep 1, 2019, 2:27:16 AM
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
      <s:url var ="styleurl" value ="/resource/css/bootstrap.min"/>
        <link href="${styleurl}" rel="stylesheet" type="text/css"> 
        <!-- Custom CSS -->
        <s:url var ="customurl" value ="/resource/css/sb-admin-2.css"/>
        <link href="${customurl}" rel="stylesheet" type="text/css">

        <!-- font awasome -->
        <s:url var ="fonturl" value ="/resource/css/font-awesome-4.7.0/css/font-awesome.min.css"/>
        <link href= "${fonturl}" rel="stylesheet" type="text/css"/>



       <%-- <s:url var ="bootstrappicker" value ="/resource/assets/css/bootstrap.css"/>
        <link href="${bootstrappicker}" rel="stylesheet" type="text/css" /> --%>
        <s:url var ="bootstrappickerurl" value ="/resource/assets/css/bootstrap-datepicker.css"/>

        <link href="${bootstrappickerurl}" rel="stylesheet" type="text/css"/>


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
                                    
                                   <s:url var ="assetAssignmenturl" value ="/asset/assignPage"/>
                                     <s:url var ="AssignedAsseturl" value ="/asset/showAssignedAssets?pageNo=1"/>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${assetregurl}" ><h5>Add Asset</h5></a>
                                </li>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${manageasseturl}"  ><h5>Add Warranty</h5> </a>
                                </li>
                               
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${assetAssignmenturl}" ><h5>Assign Assets</h5></a>
                                </li>
                                <li class=" nav-item font-weight-bold " > <a class ="nav-link" href="${AssignedAsseturl}" ><h5>Show Assigned</h5></a>
                                </li>  
                                      <s:url var ="EmpassetAssignmenturl" value ="/asset/search_empPage"/>
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${EmpassetAssignmenturl}" ><h5>Employee Assets</h5></a>
                                </li>
                                <s:url var ="historyurl" value ="/asset/assetHistoryPage?pageNo=1"/>
                                <li class="nav-item font-weight-bold mr-auto" > <a class ="nav-link" href="${historyurl}" ><h5>Asset History</h5></a>
                                </li>
                            </ul>


                            <!-- search user -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="tile">
                                        <h4 class="tile-title text-primary">Add Assignment information </h4>
                                          <c:if test="${param.act eq 'assigned'}">
                                            <h3 class="text-success"> Asset assigned Successfully</h3>
                                       </c:if>
                                              <c:if test="${param.act eq 'error'}">
                                            <h3 class="text-danger"> This Asset is already  assigned</h3>
                                       </c:if>
                                              <c:if test="${message!=null}">
                                            <h3 class="text-danger">${message}</h3>
                                       </c:if>
                                        <c:if test ="${noEmpMessage!=null}">
                                            <h3 class ="text-danger">${noEmpMessage}</h3>
                                        </c:if>
                                               <c:if test ="${empmessage!=null}">
                                            <h3 class ="text-danger">${empmessage}</h3>
                                        </c:if>
                                         
                                        <s:url  var ="assignUrl" value="/asset/assignAssetToEmployee"/>
                                        <div class="tile-body">
                                            <f:form action ="${assignUrl}" modelAtribute ="command" method="POST">
                                                <div class="form-row">

                                                    <div class="form-group col-md-6">

                                                        <div class="form-group row">
                                                            <label for="employee_code" class="font-weight-bold text-primary font-italic control-label col-md-4 col-form-label text-md-left ml-2">Employee Code</label>
                                                            <div class="form-group col-md-6">
                                                                <input name="code" type="text" value="${code}"  class="form-control"placeholder=" Employee Code"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label for="asset_code" class="font-weight-bold text-primary font-italic col-md-4 col-form-label text-md-left ml-2">Asset Code</label>
                                                            <div class="form-group col-md-6">
                                                                <input name="assetCode" type="text" value="${param.assetCode}"  class="form-control" placeholder="Enter Asset Code"/>
                                                            </div>
                                                        </div>




                                                        <div class="form-group row">
                                                            <label  for="asset quantity" class="font-weight-bold text-primary font-italic col-md-4 col-form-label text-md-left ml-2">Asset Quantity</label>
                                                            <div class="form-group col-md-6">
                                                                <f:input path ="quantity" type="text" class="form-control"  placeholder="Enter quantity like 2"/>
                                                                <f:errors path="quantity" class="text-danger"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label  for="assign_date" class="font-weight-bold text-primary font-italic col-md-4 col-form-label text-md-left ml-2">Assigned Date</label>
                                                            <div class="form-group col-md-6">
                                                                <f:input path ="assignDate" class="datepicker form-control" type ="text" placeholder="Select assign date" />

                                                                  <f:errors path="assignDate" class="text-danger"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-6">
                                                        <div class="form-group row">
                                                            <label  for="check_ot_number" class="font-weight-bold text-primary font-italic col-md-4 col-form-label text-md-left ml-2">Check Out Number </label>
                                                            <div class="form-group col-md-6">

                                                                <f:input path ="checkOutNumber" type="text" class="form-control"  placeholder="Enter value like 495124"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="remark" class="font-weight-bold text-primary font-italic col-md-4 col-form-label text-md-left ml-2">Remark </label>
                                                            <div class="form-group col-md-6">

                                                                <f:textarea path ="remark" type="text" class="form-control"  rows ="3" placeholder="Enter your remark"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group purple-border">
                                                            <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Assign Asset</button>
                                                        </div>
                                                    </div>
                                                </div>










                                            </f:form>



                                        </div>


                                    </div>


                                    <%-- asset search start --%>
                                    <div class="tile">
                                        <h4 class="tile-title text-primary font-weight-bold">Search Employee  </h4>
                                        <div class="tile-body"> 
                                            <s:url var ="employeeSearchUrl"  value="/asset/employee_search"/>
                                            <form action ="${employeeSearchUrl}" method ="get">
                                                <div class="form-row">

                                                    <div class="form-group col-md-4">

                                                        <input  type="text" name ="searchText" value="${param.searchText}" class="form-control"  placeholder="Enter Employee Code"/>
                                                    </div>
                                                    <div class="form-group col-md-3">

                                                        <div class="form-group purple-border">
                                                            <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Search Employee</button>
                                                        </div>
                                     
                                                    </div>
                                                </div>

                                   


                                            </form>
                                          <c:if test="${empMessage!=null}">
                                            <p class="text-danger">${empMessage}</p>
                                       </c:if> 


                                        </div>
                                    </div>  <%-- asset search end %-->
                                        
                                  
                                    <%-- table body--%>
                                       <c:if test="${emps!=null}">
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
                                                            <th> Action</th>

                                                    </tr>
                                                </thead>

                                                <tbody>

                                                    <tr>
                                                        <td>${emps.firstName}</td>
                                                        <td>${emps.middleName}</td>
                                                        <td>${emps.lastName}</td>
                                                        <td>${emps.email}</td>
                                                        <td>${emps.age}</td>
                                                        <td>${emps.code}</td>
                                                        <s:url var="assignAssetToEmployeeUrl" value="/asset/assignPage">
                                                         <s:param name="code" value="${emps.code}"/>
                                                        </s:url>
                                                        <s:url var ="assignempassetlist" value="/asset/showEmployeAsset">
                                                            <s:param name ="employeeId" value="${emps.employeeId}"/>
                                                        </s:url>
                                                        <td> 
                                                      <a class ="nav-item" href="${assignempassetlist}">show assignment</a>| <a href="${assignAssetToEmployeeUrl}">Assign item</a>
                                                        </td>
                                                    </tr>



                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                       </c:if>
                                    <%-- table end --%>
                                </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->

                    </div>
                </div>
        </main>



        <s:url var="urlpopper" value="/resource/js/popper.min.js" />
        <script src="${urlpopper}"></script>
        <s:url var="urlboot" value="/resource/js/bootstrap.min.js" />
        <script src="${urlboot}"></script>
        <s:url var="urlmain" value="/resource/js/main.js" />
        <script src="${urlmain}"></script>
        <!-- The javascript plugin to display page loading on top-->
        <s:url var="urlpace" value="/resource/js/plugin/pace.min.js" />
        <script src="${urlpace}"></script>
        ]
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
     <s:url var = "jqueryurl" value ="/resource/js/jquery-3.2.1.min.js"/>
     <script src="${jqueryurl}" type = "text/javascript"></script>


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




