<%--
  Created by IntelliJ IDEA.
  User: Kristina
  Date: 24/03/2016
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Muuda raadio</title>
    <style>
        input{
            width: 300px;
        }
        .submit{
            width: 70px;
        }
    </style>
</head>
<body>
<a href='/radio/s'>servlet</a> | <a href='/log.txt'>log.txt</a> <br>

<c:forEach items="${radioerrors}" var="error">
    ${error.key} - ${error.value}<br>
</c:forEach>

<c:if test="${radioerrors.get('Viga') == null}">

    <form method="POST" action='/radio/s' name="frmAddRadio">
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" readonly="readonly" name="radio" value="<c:out value="${radio.id}" />" /> <br/></td>
            </tr>
            <tr>
                <td>Station name: </td>
                <td><input type="text" name="name" value="<c:out value="${radio.name}" />" /> <br/></td>
            </tr>
            <tr>
                <td>Sequence: </td>
                <td><input type="text" name="sequence" value="<c:out value="${radio.sequence}" />" /> <br/></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="<c:out value="${radio.description}" />" /> <br/></td>
            </tr>
        </table>
        <input class="submit" type="submit" value="Submit" />
    </form>

</c:if>


</body>
</html>
