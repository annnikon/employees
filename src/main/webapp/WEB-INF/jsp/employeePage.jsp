<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anikonova
  Date: 12.02.18
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String depName = request.getParameter("name");
%>
<html>
<head>
    <title>Add | Edit employee</title>
</head>
<body>
<form method="post" action="saveEmployee">
    Email: <input name="email" type="text"/>
    <br/>
    Name: <input name="name" type="text"/>
    Birthday: <input name="birthday" type="text"/>
    Room: <input name="room" type="text"/>
    Department:
<select name="department" SIZE="5" width="20">
    <c:forEach var="department" items="${departments}">
        <option>
            <c:out value="${department.getName()}" />
        <option value="${department.getName()}"
        ${department.getName().equals(depName) ? 'selected' : ''}/>
        </option>
    </c:forEach>
</select>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
