<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.SpringProject.StudentCourseMappings.Entity.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Students</title>
</head>
<body>
    <h1>All Students</h1>
    <form action="viewStudents">
    <table>
        <thead>
            <tr>
                <th>Student ID</th>
                <th> Name</th>
                <th>Roll No</th>
                <th>Class</th>
                  <th>Course ID</th>
                                <th> CourseName</th>
                                  <th>CourseDept</th>


            </tr>
        </thead>
        <tbody>
<%
              List<Student> studentList= (List<Student>) request.getAttribute("viewStudents");
for (Student student : studentList) {
          %>
              <tr>
                  <td><%=student.getSid() %></td>
                  <td><%= student.getSname() %></td>
                  <td><%=student.getSrollno() %></td>
                  <td><%= student.getSclass() %></td>
                  <td><%=student.getCourses().getCid() %></td>
                                    <td><%= student.getCourses().getCname() %></td>
                                    <td><%=student.getCourses().getCdept() %></td>
              </tr>
          <%
              }
          %>
        </tbody>
    </table>
    </form>
    <form action="/home">
            <input type="submit" value="Go to Home">
        </form>
</body>
</html>


