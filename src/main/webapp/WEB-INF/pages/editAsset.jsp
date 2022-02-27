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
                                 <s:url var ="manageasseturl" value ="/warranty/warranty_page"/>
                                    <s:url var="assetregurl" value ="/asset/asset_reg"/>
                                    <s:url var ="assetFinanceInfourl" value ="/financeInfo/financeInfo_page"/>
                            <s:url var ="assetStoreurl" value ="/asset/assetStorePage?pageNo=1"/>

                                <li class =" tile-title nav-item font-weight-bold"><a  class ="nav-link" href="${assetregurl}" ><h5>Add Asset</h5></a>
                                </li>
                                <li class=" tile-title nav-item font-weight-bold"  ><a class ="nav-link" href="${manageasseturl}"  ><h5>Add Warranty</h5> </a>
                                </li>
                                <li class=" tile-title nav-item font-weight-bold" > <a class ="nav-link" href="${assetStoreurl}" ><h5>Asset Store</h5></a>
                                </li>
                                <s:url var ="assetAssignmenturl" value ="/asset/assignPage"/>
                                <li class=" nav-item tile-title font-weight-bold " > <a class ="nav-link" href="${assetAssignmenturl}" ><h5>Assign Assets</h5></a>
                                    <s:url var ="AssignedAsseturl" value ="/asset/showAssignedAssets?pageNo=1"/>
                                </li>
                                <li class=" nav-item  tile-title font-weight-bold" > <a class ="nav-link" href="${AssignedAsseturl}" ><h5>Show Assigned</h5></a>
                                </li>
                                       <s:url var ="EmpassetAssignmenturl" value ="/asset/search_empPage"/>
                                <li class=" nav-item tile-title font-weight-bold" > <a class ="nav-link" href="${EmpassetAssignmenturl}" ><h5>Employee Assets</h5></a>
                                </li>
                                <s:url var ="historyurl" value ="/asset/assetHistoryPage?pageNo=1"/>
                                <li class="nav-item tile-title font-weight-bold mr-auto" > <a class ="nav-link" href="${historyurl}" ><h5>Asset History</h5></a>
                                </li>
                            </ul>

                           
                            

                              

                                    <!-- type of user -->
                                    <div class="row">

                                    
                                        <c:if test ="${param.act eq 'asset_reg'}">
                                            <h5 class="font-weight-bold ml-5 mt-5 text-success">Asset successfully saved!</h5>
                                        </c:if>
                                                 <c:if test ="${AssetMessage!=null}">
                                            <h5 class="font-weight-bold ml-5 mt-5 text-success">${  AssetMessage}</h5>
                                        </c:if>
                                                   <c:if test ="${employeeAssetMessage!=null}">
                                            <h5 class="font-weight-bold ml-5 mt-5 text-success">${  employeeAssetMessage}</h5>
                                        </c:if>
                                        <c:if test="${message_cat!=null}"><h3 class="font-weight-bold ml-5 mt-5 text-danger">${message_cat}</h3></c:if>
                                    </div>
                                    <!-- search user -->
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="tile">
                                                <h4 class="tile-title">Update Asset</h4>
                                                <div class="tile-body">
                                                    <s:url  var ="assetEditurl" value ="/asset/asset_edit"/>
                                                    <f:form action ="${assetEditurl}" modelAttribute="command">
                                                        <div class="form-row">
                                                            
                                                            <div class="form-group col-md-3">
                                                                    <f:input path="assetId" type="hidden"/>
                                                                <f:input path ="assetName" type="text" class="form-control"  placeholder="Enter asset serial number"/>
                                                                
                                                            </div>
                                                            <div class="form-group col-md-3">
                                                                
                                                                <f:input path ="assetCode" type="text" class="form-control"  placeholder="Enter asset tag/code"/>
                                                             
                                                            </div>
                                                            <div class="form-group col-md-3">
                                                               
                                                                <f:input path ="brand" type="text" class="form-control"  placeholder="Enter asset brand"/>
                                                                
                                                            </div>
                                                            <div class="form-group col-md-3">

                                                                <f:input  path ="model" type="text" class="form-control"  placeholder="Enter asset model"/>
                                                            </div>
                                                        </div>
                                                     <div class="form-row">

                                                            <div class="form-group col-md-3">
                                                              
                                                                <f:input path  ="price" type="text" class="form-control"  placeholder="Enter asset Price"/>
                                                            </div>
                                                          
                                                            <div class="form-group col-md-3">
                                                              <f:select   path ="currentCondition" type ="text" class ="form-control">
                                                                  <f:option value="" label="-- select condition --"/>
                                                                                    <f:option value="in store" label="in store"/>
                                                                                    <f:option value="in use" label="in use"/>
                                                                                    <f:option value="loaned out" label="loaned out"/>
                                                                                   <f:option value="out for repair" label="out for repair"/>


                                                                  </f:select>
                                                            </div>
                                                            <div class="form-group col-md-3">

                                                               <f:select   path ="qualityCondition" type ="text" class ="form-control">
                                                                   <f:option value="" label="-- select quality --"/>
                                                                                    <f:option value="new" label="new"/>
                                                                                    <f:option value="used" label="used"/>


                                                                  </f:select>
                                                            </div> 
                                                            <div class="form-group col-md-3">

                                                               <f:select path ="catagory.catagoryId"   type ="text" class ="form-control">
                                                                   <f:option value="" label="-- select category --"/>
                                                                   <f:options items="${catagorylist}" itemLabel ="catagoryName" itemValue ="catagoryId"/>
                                                                                    


                                                               </f:select>
                                                            </div>
                                                        </div>
                                                          <div class="form-row">
                                                                <div class="form-group col-md-8 ">
    <div class="form-group purple-border">
  <label for="desription">Asset description</label>
  <f:textarea path ="description" class="form-control"  rows="3"></f:textarea>
</div> 
                                                                        </div> 
                                                                                    
                                                        <div class="form-group col-md-4 text-right">
    <div class="form-group purple-border">
                                                          <button class="mt-5 ml-5 btn btn-primary"  type="submit"><i class="fa fa-plus "></i>Update asset</button>
                                                        </div>
                                                               </div>  
                                                    </f:form>

                                                </div>
                                    

                                            </div>
                                        </div>
                                    </div>

                                 
                                </div>
                       
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

