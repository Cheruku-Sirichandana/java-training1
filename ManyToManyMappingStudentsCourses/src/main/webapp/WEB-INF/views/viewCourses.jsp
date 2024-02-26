<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.CoursesModel" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Details</title>
</head>
<body>

    <h1>Course Details</h1>
    <table>
        <tr>
            <th>CourseID</th>
            <th>CourseName</th>
            <th>CourseDept</th>
            <th>View Students</th>
            <th>Add Students</th>
            <th>Update Course</th>
            <th>Delete Course</th>  </tr>
        <%
            List<CoursesModel> courseList = (List<CoursesModel>) request.getAttribute("coursesList");
            if (courseList != null) {
                for (CoursesModel course : courseList) {
        %>
        <tr>
            <td><%= course.getCid() %></td>
            <td><%= course.getCname() %></td>
            <td><%= course.getCdept() %></td>
              <td><form action="/viewCoursesStudent">
                 <input type="hidden" name="cid" value="<%= course.getCid() %>" >
                   <input type="submit" value="view Students"></form></td>
       <td><form action="/addStudentToCourse">
                    <input type="hidden" name="cid" value="<%= course.getCid() %>" >
                    <input type="submit" value="add Students"></form></td>

             <td><form action="/updateCourse">
               <input type="hidden" name="cid" value="<%= course.getCid() %>" >
               <input type="submit" value="Update"></form></td>
             <td><form action="/deleteCourse">
               <input type="hidden" name="cid" value="<%= course.getCid() %>" >
                <input type="submit" value="Delete"></form></td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td>No Courses found</td>
        </tr>
        <% } %>

    </table>

       <h3> <a href="home">Home</a></h3>


</body>
</html>
