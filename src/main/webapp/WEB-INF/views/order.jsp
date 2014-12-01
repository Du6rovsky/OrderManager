<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf8">
		<title><spring:message code="label.title" /></title>
	</head>
  <body>
  	
  	<h2><spring:message code="label.AddNewOrder" /></h2>
    <form:form method="post" action="add" commandName="order" enctype="multipart/form-data">
        <table width="60%" border="1" cellspacing="0">
            <tr>
                <td width="35%"><strong><spring:message code="label.OrderToUpload" /></strong></td>
                <td width="65%"><input type="file" name="order" /></td>
            </tr>
            <tr>
                <td><strong><spring:message code="label.Number" /></strong></td>
                <td><input type="text" name="number" width="60" /></td>
            </tr>
            <tr>
                <td><strong><spring:message code="label.Theme" /></strong></td>
                <td><input type="text" name="theme" width="60" /></td>
            </tr>
            <tr>
                <td><strong><spring:message code="label.Notes" /></strong></td>
                <td><input type="text" name="notes" width="60" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="submit" value="<spring:message code="label.AddOrder"/>"/></td>
            </tr>
        </table>
    </form:form>      	
	
	<c:if  test="${!empty orderList}">  
    <table width="100%" border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th width="6%"><spring:message code="label.Number" /></th>
            <th width="5%"><spring:message code="label.Date" /></th>
            <th width="29%"><spring:message code="label.Theme" /></th>
            <th width="20%"><spring:message code="label.FileName" /></th>
            <th width="20%"><spring:message code="label.Notes" /></th>
            <th width="15%"><spring:message code="label.Type" /></th>
            <th width="15%">&nbsp;</th>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.number}</td>
                <td>${order.date}</td>
                <td>${order.theme}</td>
                <td>${order.filename}</td>
                <td>${order.notes}</td>
                <td>${order.type}</td>
                <td><div align="center"><a href="download/${order.id}"><spring:message code="label.Download" /></a> /
                    <a href="delete/${order.id}"><spring:message code="label.Delete" /></a></div>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
  </body>
</html>