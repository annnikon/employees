<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit / Create new department</title>

</head>
<body>
<form method="post" action="DepartmentServlet">
    <input type="hidden" name="name" value="${department.getName()}">
    Name: <input type="text" name="newName" value="${department.getName()}"/>
    Info: <input type="text" name="newInfo" value="${department.getInfo()}"/>
    <c:if test="${not empty department}"> <input type="submit" name="action" value="edit"/> </c:if>
    <c:if test="${empty department}>"><input type="submit" name="action" value="add"/> </c:if>

</form>

</body>
</html>
