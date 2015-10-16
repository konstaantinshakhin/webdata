<%--
  Created by IntelliJ IDEA.
  User: kshahin
  Date: 10/14/2015
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Все записи</title>
</head>
<body>
<table border="1px">
    <tr>
        <td><b>СНИЛС</b></td>
        <td><b>ФИО</b></td>
        <td><b>Дата Рождения</b></td>
        <td><b>Пол</b></td>
        <td><b>Место Рождения</b></td>
        <td><b>Действия</b></td>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.snils}</td>
            <td>${person.fio}</td>
            <td>${person.birthDate}</td>
            <td>${person.gender}</td>
            <td>${person.birthPlace}</td>
            <td><a href="/editPerson?id=${person.id}">Edit</a> | <a href="/deletePerson?id=${person.id}">Delete</a> |  <a href="/history?id=${person.id}">history</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <a href="/addPerson">Добавить запись</a>
        </td>
    </tr>
</table>
</body>
</html>

