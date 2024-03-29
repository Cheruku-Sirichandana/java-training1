<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.MappingOneToMany.Entity.Courses" %>
<%@ page import="com.example.MappingOneToMany.Entity.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
<center>
    <h1>Student Details</h1>
    <table border="1">
        <tr>
            <th>CourseID</th>
            <th>CourseName</th>
            <th>CourseAge</th>
            <th>Delete</th>
        </tr>
        <%
            List<Courses> courseList = (List<Courses>) request.getAttribute("coursesList");
            if (courseList != null) {
                for (Courses course : courseList) {
        %>
        <tr>
            <td><%= course.getCourseId() %></td>
            <td><%= course.getCourseName() %></td>
            <td><%= course.getCourseGuide() %></td>
             <td><form action="/deleteCourseDone">
               <input type="hidden" name="CourseId" value="<%= course.getCourseId() %>" >
                <input type="submit" value="Delete"></form></td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No Courses found</td>
        </tr>
        <% } %>

    </table>

       <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
