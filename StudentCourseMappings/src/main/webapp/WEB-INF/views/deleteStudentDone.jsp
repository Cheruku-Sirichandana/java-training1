<%@ page import="com.SpringProject.StudentCourseMappings.Entity.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>

    <title>All Student Details</title>
</head>
<body>
<h1>Student Details</h1>
<form action="deleteStudentSuccess" method="get">
    <label>Student Id :</label>
    <input type="number" name="sid" id="sid" required>
    <input type="submit" value="Search">
    </form>
    <div>
        <%
           boolean deletedStudent = (boolean) request.getAttribute("deletedStudent");
            Student student= (Student) request.getAttribute("student");

                    if(deletedStudent){

        %>
            <h1> ${student.sname} deleted Successfully </h1>
        <%
        } else {
        %>
        <h1> Student Id Not found </h1>
        <%
            }
        %>
        <form action="/home">
            <input type="submit" value="Go to Home Page">
        </form>
    </div>
</body>
</html>
