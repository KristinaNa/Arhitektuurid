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
    <title>Show All Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>First Name</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${radios}" var="radio">
        <tr>
            <td><c:out value="${radio.name}" /></td>
            <td><c:out value="${radio.sequence}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="RadioController?action=insert">Add User</a></p>
</body>
</html>