<%-- 
    Document   : catagorylist
    Created on : May 18, 2019, 8:49:43 AM
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
        <link href="${customurl}" rel="stylesheet" type ="text/css">

        <!-- font awasome -->
        <s:url var ="fonturl" value ="/resource/css/font-awesome-4.7.0/css/font-awesome.min.css"/>
        <link href= "${fonturl}" rel="stylesheet" type="text/css"/> 

        <!-- Font-icon css-->
    </head>
    <body>
        <!-- Navigation -->
        <%@include file="./shared/header.jsp"%>
        <!-- Side Navigation -->
        <%@include file="./shared/leftside.jsp"%>
        <main class="app-content">
            <c:if test="${empty catagotries}">
                                <tr>
                                    <td align="center" colspan="8" class="error">No Records Present</td>
                                </tr>
                            </c:if>
            <div class="tile">
                <div class="tile-body">
                    <s url  var ="deleteurl" value="/clidst"/>
                   
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                            <tr>
                                <th>Catagory id</th>
                                <th>Catagory name</th>
                                <th>Catagory name</th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var ="c" items ="${catagotries}">
                                <tr>
                                    <td>${c.catagoryId}</td>
                                    <td>${c.catagoryName}</td>
                                   <s:url var="url_edit" value="/user/edit_catagory">
                                        <s:param name="cid" value="${c.catagoryId}"/>
                                    </s:url> 
                                   
                                    <s:url var="url_del" value="/user/delete_catagory">
                                        <s:param name="cid" value="${c.catagoryId}"/>
                                    </s:url> 
                                   <s:url var="addCcUrl" value="/user/add" >
                                       <s:param name="catagoryId" value="${c.catagoryId}"/>
                                   </s:url>
                                   <td> 
                                       <a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a>| <a href="${addCcUrl}">ADD</a></td></tr>
                            </c:forEach>

                                
                        </tbody>
                    </table>
                  
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
