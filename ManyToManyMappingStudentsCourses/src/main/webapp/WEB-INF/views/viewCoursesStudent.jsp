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
             <td><form action="/updateStudent">
              <input type="hidden" name="sid" value="<%= student.getSid() %>" >
               <input type="submit" value="UpdateStudent"></form></td>

          <td><form action="/deleteStudentOfCourse">
             <input type="hidden" name="cid" value="${cid}" >

          <input type="hidden" name="sid" value="<%= student.getSid() %>" >
              <input type="submit" value="DeleteStudent"></form></td>


        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td>No students found</td>
        </tr>
        <% } %>

    </table>
       <h3> <a href="home">Home</a></h3>


</body>
</html>
