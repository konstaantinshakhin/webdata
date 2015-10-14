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
<table width="600px">
    <tr>
        <td><b>СНИИЛС</b></td>
        <td><b>ФИО</b></td>
        <td><b>Дата Рождения</b></td>
        <td><b>Пол</b></td>
        <td><b>Место Рождения</b></td>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.snils}</td>
            <td>${contact.fio}</td>
            <td>${contact.birthDate}</td>
            <td>${contact.gender}</td>
            <td>${contact.birthPlace}</td>
            <td><a href="/edit?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a> <a href="/history?id=${contact.id}">history</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/add">Добавить запись</a>
        </td>
    </tr>
</table>
</body>
</html>

