<%--
  Created by IntelliJ IDEA.
  User: kshahin
  Date: 10/16/2015
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>История изменений</title>
</head>
<body>
<table border="1px">
    <tr>

       <td><b>Дата</b></td>
       <td><b>Имя менеджера</b></td>
       <td><b>Изменение</b></td>

    </tr>
    <c:forEach var="historyes" items="${history}">
        <tr>
            <td>${history.idPerson}</td>
            <td>${history.date}</td>
            <td>${history.operationName}</td>

        </tr>
    </c:forEach>

</body>
</html>
