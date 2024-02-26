<%@ page import="com.SpringProject.StudentCourseMappings.Entity.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>

    <title>All Student Details</title>
</head>
<body>
<h1>Employee Details</h1>
<form action="searchStudentDone" method="get">
    <label>Student Id :</label>
    <input type="text" name="sid" id="sid" >
    <input type="submit" value="Search">
</form>
<div>
    <%
    Student searchedStudent= (Student) request.getAttribute("searchStudent");
 if (searchedStudent != null) {
    %>
    <p>Student ID : ${searchStudent.getSid()} </p>
    <p> Name   : ${searchStudent.getSname()} </p>
    <p>Roll No      :  ${searchStudent.getSrollno()}</p>
        <p>Class   :  ${searchStudent.getSclass()}</p>
        <p>Course ID : ${searchStudent.getCourses().getCid()} </p>
            <p> Course Name   : ${searchStudent.getCourses().getCname()} </p>
            <p>Course Dept      :  ${searchStudent.getCourses().getCdept()}</p>
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
