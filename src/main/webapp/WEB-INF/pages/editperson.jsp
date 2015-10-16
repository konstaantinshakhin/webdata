<%--
  Created by IntelliJ IDEA.
  User: kshahin
  Date: 10/16/2015
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить контакт</title>
</head>
<body>
<form:form method="POST" action="/editPerson" modelAttribute="person">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>СНИЛС:</td>
            <td><form:input path="snils" /></td>
        </tr>
        <tr>
            <td>ФИО:</td>
            <td><form:input path="fio" /></td>
        </tr>
        <tr>
            <td>Дата Рождения:</td>
            <td><form:input path="birthDate" /></td>
        </tr>
        <tr>
            <td>Пол:</td>
            <td><form:input path="gender" /></td>
        </tr>
        <tr>
            <td>Место Рождения:</td>
            <td><form:input path="birthPlace" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

