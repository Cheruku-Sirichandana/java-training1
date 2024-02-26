<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.StudentsModel" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>

    <h1>Student Details</h1>
    <table>
        <tr>
            <th>StudentID</th>
            <th>StudentName</th>
            <th>StudentClass</th>
            <th>Courses</th>
            <th>Add Course</th>
            <th>Update Student</th>
            <th>Delete student</th>
        </tr>
        <%
            List<StudentsModel> students = (List<StudentsModel>) request.getAttribute("studentsList");
            if (students != null) {
                for (StudentsModel student : students) {
        %>
        <tr>
            <td><%= student.getSid() %></td>
            <td><%= student.getSname() %></td>
            <td><%= student.getSclass() %></td>

            <td><form action="/viewStudentCourses">
                <input type="hidden" name="sid" value="<%= student.getSid() %>" >
                <input type="submit" value="viewCourses"></form></td>

            <td><form action="/AddCoursesToStudent">
                <input type="hidden" name="sid" value="<%= student.getSid() %>" >
                <input type="submit" value="AddCourse"></form></td>

            <td><form action="/updateStudent">
                <input type="hidden" name="sid" value="<%= student.getSid() %>" >
                <input type="submit" value="UpdateStudent"></form></td>

            <td><form action="/deleteStudent">
                <input type="hidden" name="sid" value="<%= student.getSid() %>" >
                <input type="submit" value="DeleteStudent"></form></td>


        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3">No students found</td>
        </tr>
        <% } %>

    </table>
<%--    </h2>${msg}</h2>--%>
    <h3> <a href="home">Home</a></h3>

</center>
</body>
</html>
