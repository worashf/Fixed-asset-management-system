
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
                            <s:url var ="assetregurl" value ="/asset/asset_reg"/>
                            <s:url var ="assetWarrantyurl" value ="/warranty/warranty_page"/>
                            <s:url var ="financeInfoUrl" value ="/financeInfo/financeInfo_page"/>
                            <s:url var ="assetWarrantypageurl" value ="/warranty/assetWarrantyPage"/>
                            <ul class="nav ">
                                <li class =" nav-item font-weight-bold "><a  class ="nav-link active" href="${assetregurl}" ><h5>Add Asset</h5> </a>
                                </li>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href=" ${assetWarrantyurl}"  ><h5>Add Warranty</h5></a>
                                    
                                </li>
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${assetWarrantypageurl}" ><h5>Manage Warranty</h5></a>
                                </li>
                                <s:url var ="documentInfoUrl" value ="/document/add-documetpage"/>
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${documentInfoUrl}" ><h5>Upload document</h5></a>
                                </li
                                <s:url var ="assetAssignmenturl" value ="/asset/assignPage"/>
                                <li class=" nav-item font-weight-bold " > <a class ="nav-link" href="${assetAssignmenturl}" ><h5>Assign Assets</h5></a>
                                    <s:url var ="AssignedAsseturl" value ="/asset/showAssignedAssets?pageNo=1"/>
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
                                        <h4 class="tile-title">Attach Warranty Document  </h4>
                                        <div class="tile-body"> 
                                            <s:url var ="addDocumenturl" value="/document/save-document"/>
                                            <f:form action ="${addDocumenturl}" modelAttribute="fileBucket" method="POST" enctype="multipart/form-data" >
                                                <div class="form-row">

                                                    <div class="form-group col-md-3">
                                                        <label class="label-primary font-weight-bold font-italic" for="desription">Warranty Id</label>
                                                   <input name="warrantyId" type="text" value="${param.warrantyId}"  class="form-control" readonly/>
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                 <label class="label-primary font-weight-bold font-italic" for="desription">Upload Document</label>
                                                        <f:input path="file" type="file" class="form-control"  placeholder="atach file"/>
                                                        <f:errors path="file" class="text-danger"/>
                                                    </div>
                                                 
                                                </div>
                                                <div class="form-row">

                                           

                                                    <div class="form-group col-md-3">
                                                           <label class="label-primary  font-weight-bold font-italic" for="desription">Document description</label>
                                             <f:textarea path ="description" class="form-control"  placeholder="Enter document description" rows="3"></f:textarea>
                                                    </div>
                                     
                                
                                                     <div class="form-group col-md-3 mt-5">
                                                     
                                                        <div class="form-group purple-border">
                                                            <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Save document</button>
                                                        </div>
                                                    
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


    </body>
</html>



