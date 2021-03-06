<%--
  Created by IntelliJ IDEA.
  User: Kristina
  Date: 24/03/2016
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Show All Radios</title>
    </head>
    <body>
    <a href='/radio/s'>servlet</a> | <a href='/log.txt'>log.txt</a> <br>

    <table border=1>
        <thead>
        <tr>
            <th>Id</th>
            <th>Station Name</th>
            <th>FM</th>
            <th>Description</th>
            <td></td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <p><h3> Radio stations list: </h3></p>
        <c:forEach items="${radios}" var="radio">
            <tr>
                <td><c:out value="${radio.id}" /></td>
                <td><c:out value="${radio.name}" /></td>
                <td><c:out value="${radio.sequence}" /></td>
                <td><c:out value="${radio.description}" /></td>
                <td><a href="/radio/s?action=edit&id=<c:out value="${radio.id}"/>">muuda</a></td>
                <td><a href="/radio/radioservice?action=data&id=<c:out value="${radio.id}"/>">kirjeldus</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </body>
</html>