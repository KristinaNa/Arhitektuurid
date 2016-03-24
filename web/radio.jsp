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
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
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
    <form method="POST" action='RadioController' name="frmAddRadio">
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" readonly="readonly" name="radioid" value="<c:out value="${radio.id}" />" /> <br/></td>
            </tr>
            <tr>
                <td>Station name: </td>
                <td><input type="text" name="name" value="<c:out value="${radio.name}" />" /> <br/></td>
            </tr>
            <tr>
                <td>Sequence: </td>
                <td><input type="text" name="fm" value="<c:out value="${radio.sequence}" />" /> <br/></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="<c:out value="${radio.description}" />" /> <br/></td>
            </tr>
        </table>
        <input class="submit" type="submit" value="Submit" />
    </form>




</body>
</html>
