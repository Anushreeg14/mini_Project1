<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIN Succuessfully</title>
 <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
           
            justify-content: center;
           
            height: 50vh;
        }
        h1
        {
        text-align: center;
            color: #120101;
        }
        h2 {
            text-align: center;
            color: #f8f4f4;
            background-color:  #120101;
        }

        table {
            width: 40%;
            margin-top: 20px;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            margin-left: 30%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #120101;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>



<%@page import ="com.log.lohin2.EmployeeDetails" %>
<%@page import ="com.log.lohin2.Employee" %>
<%
String name=request.getParameter("name");
String pswd=request.getParameter("pswd");
Employee emp=EmployeeDetails.getEmployee(name, pswd);
request.setAttribute("emp",emp);
%>
<h2>Employee Details</h2>
<h1>Hello.. <%=emp.getName()%> </h1>
<table>
<tr>
     <th>Employee Id:<th>
     <td><%=emp.getId()%><td>
</tr>
<tr>
     <th>Employee Name:<th>
     <td><%=emp.getName()%><td>
</tr>
<tr>
     <th>Employee salary:<th>
     <td><%=emp.getSalary()%><td>
</tr>
<tr>
     <th>Employee Domain:<th>
     <td><%=emp.getDomain()%><td>
</tr>
</table>

</body>
</html>