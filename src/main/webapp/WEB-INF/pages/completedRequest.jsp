<%-- 
    Document   : completedRequest
    Created on : Feb 7, 2021, 8:01:53 AM
    Author     : best
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
                                <s:url var ="requestlisturl" value ="/request/request_list"/>
                                <s:url var ="personallisturl" value ="/request/personal_asset"/>
                                <s:url var="request_url" value ="/request/request_page"/> 
                                <s:url var="requestApproveBymanagerurl" value ="/request/requestApproveManager"/> 
                         <s:url var="requestApproveByStoreKepeerurl" value ="/request/store-kepeer-request-list"/>     
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${request_url}" ><h5>New Request</h5></a>
                                </li>
                                <li class =" nav-item font-weight-bold"><a  class ="nav-link " href="${personallisturl}" ><h5>Your Asset</h5></a>
                                </li>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href="${requestlisturl}"  ><h5>Request List</h5> </a>
                                </li>
                                <li class="nav-item  font-weight-bold " ><a class ="nav-link" href="${requestApproveBymanagerurl}" ><h5>Approved Requests </h5></a>
                                </li>
                                 <li class="nav-item font-weight-bold mr-auto" ><a class ="nav-link" href="${requestApproveByStoreKepeerurl}"><h5>Completed Requests</h5> </a>
                                </li>
                            </ul>






                            <!-- type of user -->
                            <div class="row">

                                <div class=" mt-3 col-md-6 col-lg-3">
                                    <div class="widget-small info coloured-icon"><i class="icon fa fa-star fa-4x"></i>
                                        <div class="info">
                                            <h4>Requests</h4>
                                            <p><b>50</b></p>
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
                                <div class=" mt-3 col-3">

                                    <label class="text-info">Logged in user: </label>  <span class ="text-danger">${emp.firstName}</span>    </br>

                                    <label class="text-info">User Name : </label>     <span class ="text-danger"> ${user.username}</span>


                                </div>
                                <div class=" mt-3 col-6">

                                    <label class="text-primary">???????????? ????????? ?????????: </label>   <span class ="mr-3"> ${requests.user.empployee.department.name}</span>  </br>


                                    <label class="text-primary">???????????? ??????: </label>   <span class ="mr-3"> ${requests.user.empployee.firstName}</span> <span>${requests.user.empployee.lastName}</span> 

                                </div>
                            </div>


                            <div class="form-group row">
                                <div  class=" card-header col-md-3 col-form-label ">Number</div>
                                <div  class=" card-header col-md-3  col-form-label text-md-left">Item</div>
                                <div  class=" card-header col-md-3  col-form-label text-md-left mr-auto">Quantity(number)</div>
                                <div  class=" card-header col-md-3  col-form-label text-md-left mr-auto">Approved(number)</div>

                            </div>
                            <s:url var ="requestManagerApprove" value="/request/request-store-kepeer-Completed"/>
                            <f:form action ="${requestManagerApprove}" modelAttribute="request" method="post">
                               <f:input type="hidden" path ="statusStage" value="${requests.statusStage}"/>
                                <c:if test = "${requests.quantity1 != 0}"> 
                                    <div class="form-group row ">

                                        <f:input type="hidden" path ="requestId" value="${requests.requestId}"/>
                                        <label for="first_name" class=" col-md-2 card-header text-primary ">Item 1</label>

                                        <div class=" col-md-3">

                                            <f:input path ="item1" type="text"  value ="${requests.item1}" class="form-control" readonly="true"/>

                                        </div>


                                        <div class="col-md-3">

                                            <f:input   path ="quantity1" type="text" value ="${requests.quantity1}" class="form-control" readonly="true"/>

                                        </div>  

                                        <div class="col-md-3">

                                            <f:input   path ="approved1" type="text" value ="${requests.approved1}" class="form-control" readonly ="true"/>

                                        </div>  

                                    </div>
                                </c:if>
                                <c:if test ="${requests.quantity2 != 0}"> 
                                    <div class="form-group row">
                                        <label for="first_name" class="card-header text-primary col-md-2 ">Item 2</label>

                                        <div class="col-md-3">

                                            <f:input  path ="item2" type="text" value ="${requests.item2}" class="form-control" readonly="true"/>

                                        </div>


                                        <div class="col-md-3">

                                            <f:input  path  ="quantity2" type="text" value ="${requests.quantity2}" class="form-control"  readonly="true"/>

                                        </div>   
                                        <div class="col-md-3">

                                            <f:input   path ="approved2" type="text"  value ="${requests.approved2}" class="form-control" readonly ="true"/>

                                        </div> 

                                    </div>
                                </c:if>
                                <c:if test ="${requests.quantity3 != 0}"> 
                                    <div class="form-group row">
                                        <label for="first_name" class="col-md-2 card-header text-primary">Item 3</label>
                                        <div class="col-md-3">

                                            <f:input  path  ="item3" type="text" value ="${requests.item3}" class="form-control" readonly ="true"/>

                                        </div>
                                        <div class="col-md-3">

                                            <f:input  path  ="quantity3" type="text" value ="${requests.quantity3}"  class="form-control" readonly ="true"/>

                                        </div> 
                                        <div class="col-md-3">

                                            <f:input   path ="approved3" type="text" value ="${requests.approved3}" class="form-control" readonly ="true"/>

                                        </div> 
                                    </div>
                                </c:if>
                                <c:if test ="${requests.quantity4 != 0}"> 
                                    <div class="form-group row">
                                        <label for="first_name" class="col-md-2 card-header text-primary ">Item 4</label>
                                        <div class="col-md-3">

                                            <f:input  path  ="item4" type="text"  value ="${requests.item4}" class="form-control" readonly ="true"/>

                                        </div>
                                        <div class="col-md-3">

                                            <f:input  path  ="quantity4" type="text" value ="${requests.quantity4}"  class="form-control" readonly ="true"/>

                                        </div>   
                                        <div class="col-md-3">

                                            <f:input   path ="approved4" type="text" value ="${requests.approved4}" class="form-control" readonly ="true" />

                                        </div> 
                                    </div>
                                </c:if>
                                <c:if test ="${requests.quantity5 != 0}"> 
                                    <div class="form-group row">
                                        <label for="first_name" class="col-md-2 card-header text-primary">Item 5</label>
                                        <div class="col-md-3">

                                            <f:input  path  ="item5" type="text" value ="${requests.item5}"  class="form-control" readonly ="true"/>

                                        </div>
                                        <div class="col-md-3">

                                            <f:input  path  ="quantity5" type="text" value ="${requests.quantity5}" class="form-control" readonly ="true"/>

                                        </div> 
                                        <div class="col-md-3">

                                            <f:input   path ="approved5" type="text" value ="${requests.approved5}" class="form-control" readonly ="true"/>

                                        </div> 


                                    </div>
                                </c:if>
                         <div class="form-group row">
                                    <label for="first_name" class="col-md-2 card-header text-primary">Description</label>
                                    <div class="col-md-9">

                                        <f:input  path  ="description" type="text"  value ="${requests.description}" readonly ="true"  class="form-control" />

                                    </div>
                                </div>

                         <div class="form-group row">
                                    <label for="first_name" class="col-md-2 card-header text-primary">Comment</label>
                                    <div class="col-md-9">

                                        <f:textarea  path  ="managerComment" value ="${requests.managerComment}"  readonly ="true" type="text"  rows="2" class="form-control" />

                                    </div>
                                </div>
                                    <div class="form-group row">
                                    <label for="first_name" class="col-md-2 card-header text-primary">Request status</label>
                                    <div class="col-md-9">

                                       
                   <label for="first_name" class="col-md-2 card-header text-danger">Team leader  approved</label>
                                    </div>
                                </div>
                                <div class ="row">

                                    <div class ="  col-3 ml-auto">
                                        <button class=" btn-lg btn btn-primary"  type="submit">Complete</button> 
                                    </div>



                                </f:form>  
                            
                              
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


