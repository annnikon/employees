<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <span>Employees at ${currentDepartment.getName()}</span>
    <table border="1">
        <th>Email</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Room</th>
        <th>Action</th>
        <c:forEach items="${currentDepartment.getEmployees()}" var="employee">

            <tr>
                <td>${employee.getEmail()}</td>
                <td>${employee.getName()}</td>
                <td>${employee.getBirthday()}</td>
                <td>${employee.getRoom()}</td>
                <td><a href ="edit?email=${employee.getEmail()}">Edit</a></td>
                <td><a href ="delete?email=${employee.getEmail()}">Delete</a></td>

            </tr>

        </c:forEach>
        <a href ="addEmployee">Add new employee</a>
        <a href ="departments">Back to all departments</a>
    </table>
</div>

</body>
</html>
