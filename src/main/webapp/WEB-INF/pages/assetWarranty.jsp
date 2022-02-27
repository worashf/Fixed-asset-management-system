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
                           
                            <s:url var ="assetWarrantypageurl" value ="/warranty/assetWarrantyPage"/>
                            <ul class="nav ">
                                <li class =" nav-item font-weight-bold "><a  class ="nav-link active" href="${assetregurl}" ><h5>Add Asset</h5> </a>
                                </li>
                                <li class="nav-item font-weight-bold" ><a class ="nav-link" href=" ${assetWarrantyurl}"  ><h5>Add Warranty</h5></a>

                                </li>
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${assetWarrantypageurl}" ><h5>Manage Warranty</h5></a>
                                    <s:url var ="documentInfoUrl" value ="/document/add-documetpage"/>
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${documentInfoUrl}" ><h5>Upload document</h5></a>
                                </li>
                                </li>
                            
                                <s:url var ="assetAssignmenturl" value ="/asset/assignPage"/>
                                <li class=" nav-item font-weight-bold " > <a class ="nav-link" href="${assetAssignmenturl}" ><h5>Assign Assets</h5></a>
                                    <s:url var ="AssignedAsseturl" value ="/asset/showAssignedAssets?pageNo=1"/>
                                </li>
                                <li class=" nav-item  font-weight-bold" > <a class ="nav-link" href="${AssignedAsseturl}" ><h5>Show Assigned</h5></a>
                                </li>
                                <s:url var ="EmpassetAssignmenturl" value ="/asset/search_empPage"/>
                                <li class=" nav-item font-weight-bold" > <a class ="nav-link" href="${EmpassetAssignmenturl}" ><h5>Employee Assets</h5></a>
                                </li>
                                <s:url var ="historyurl" value ="/asset/assetHistoryPage?pageNo=1"/>
                                <li class="nav-item mr-auto font-weight-bold" > <a class ="nav-link" href="${historyurl}" ><h5>Asset History</h5></a>
                                </li>
                            </ul>






                            <!-- search user -->
                            <div class="row">
                                <div class="col-md-12">
                                 
                                     <%-- asset search start --%>
                                     <div class="tile">
                                        <h4 class="tile-title">Search asset </h4>
                                        <div class="tile-body"> 
                                            <s:url var ="assetwithwarrantySearchUrl"  value="/warranty/sssetWithWarranty"/>
                                            <form action ="${assetwithwarrantySearchUrl}" method ="get">
                                                <div class="row">
                                                <div class="form-row">

                                                    <div class="form-group col-12">
 
                                                        <input  type="text" name ="assetCode" value="${param.assetCode}" class="form-control"  placeholder="search by asset code"/>
                                                    </div>
                                                 
                                                </div>
                                                
                                                    
                                                        <div class="col-6 form-group purple-border">
                                                            <button class=" ml-5 btn btn-primary"  type="submit"><i class=" "></i>Search</button>
                                                        </div>
                                                </div>
                                                   
                                            </form>
                                                        <c:if test ="${message != null}">
                                                            <h1 class = "text-success">      ${message}</h1>
                                                            
                                                        </c:if>
   
                                     
                                     
                                  </div>
         <div class="row">
        <div class="col-md-12">
                   <%-- table body--%>
                     <c:if test="${assetWarranty.warranty.documents!=null}">  
                       <div class="tile">
                <div class="tile-body">
                 
                  
                    <table class="table table-hover table-bordered">
                        <thead>
                    
                            <tr>
                                
                             
                                <th> Asset Code </th>
                        
                                 <th> Warranty Name</th>
                                 <th>Start Date</th>
                                 <th>  End Date</th>
                                 <th> Document</th>

                                     <th> Action</th>
                            </tr>
                        </thead>

                        <tbody>
                                  <c:forEach items ="${assetWarranty.warranty.documents}" var  = "document">
                                <tr>
                                    
                                      <td>${assetWarranty.assetCode}</td>
                                   
                                    <td>${assetWarranty.warranty.warrantyName}</td>
                                    <td>${assetWarranty.warranty.startDate}</td>
                                    <td>${assetWarranty.warranty.endDate}</td>
                                     <td>${document.name}</td>                                          
                                          
                                   
                                  
                               
                                   <s:url var="viewocumentUrl" value="/document/downLoadDocument">
                                       <s:param name="docId" value="${document.documentId}"/>
                                   </s:url>
                                   <td> 
                                       <a href="${viewocumentUrl}">View document</a>
                                   </td>
                                </tr>
                 
</c:forEach>
                                
                                   
                        </tbody>
                    </table>
                  
                </div>
            </div>  
                     </c:if>
                   <%-- table end --%>
        </div>
    
         </div>                    
                                </div> <%-- asset search end %-->
                              <%-- table body--%>
                      <c:if test="${assetWarranty!=null}">  
                       <div class="tile">
                <div class="tile-body">
                 
                  
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                
                                <th>Asset Name</th>
                                <th> Asset Code </th>
                                 <th> Brand</th>
                                 <th> Quality condition</th>
                                 <th> Current condition</th>
                                 <th> Warranty Name</th>
                                 <th> Warranty start date</th>
                                 <th> Warranty end date</th>
                                  <th> Action</th>
                                
                            </tr>
                        </thead>

                        <tbody>
                          
                                <tr>
                                     <td>${assetWarranty.assetName}</td>
                                      <td>${assetWarranty.assetCode}</td>
                                    <td>${assetWarranty.brand}</td>
                                    <td>${assetWarranty.qualityCondition}</td>
                                    <td>${assetWarranty.currentCondition}</td>
                                  
                                    <td>${assetWarranty.warranty.warrantyName}</td>
                                    <td>${assetWarranty.warranty.startDate}</td>
                                    <td>${assetWarranty.warranty.endDate}</td>
                                          
                                   
                                  
                                   <s:url var="url_edit" value="/user/edit_catagory">
                                        <s:param name="cid" value="${assetWarranty.assetId}"/>
                                    </s:url> 
                                   
                                    <s:url var="url_del" value="/deleteAsset">
                                        <s:param name="assetId" value="${assetWarranty.assetId}"/>
                                    </s:url> 
                                   <s:url var="adddocumentUrl" value="/document/add-documetpage">
                                       <s:param name="warrantyId" value="${assetWarranty.warranty.warrantyId}"/>
                                   </s:url>
                                   <td> 
                                      <a href="${adddocumentUrl}">Add warranty document</a>
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




