<%@ page language="java" %>
<%@page import="com.example.MappingOneToMany.Entity.Student" %>

<html>
<head>
    <title>Employee Details</title>

</head>
<body>

        <%
                Student s = (Student) request.getAttribute("student");
            if (s!=null) {
        %>
            <h2>Student Details Successfully Added</h2>
              <table>
            <tr>
                <th>Student Name</th>
                <td>${student.name}</td>
            </tr>
            <tr>
                <th>Student Id</th>
                <td>${student.id}</td>
            </tr>
            <tr>
                <th>Student Age</th>
                <td>${student.age}</td>
            </tr>

        </table>
            <br>

        <% } else { %>
            <h2>The Student Id already exists.<br>Cannot create a new Student.</h2>
            <form action="addStudentResult">
                   <label for="id">Student ID:</label><br>
                   <input type="text" id="id" name="id"><br>

                   <label for="name">Name:</label><br>
                   <input type="text" id="name" name="name"><br>

                   <label for="age">Age:</label><br>
                   <input type="text" id="age" name="age"><br><br>

                   <input type="submit" value="Submit">
               </form>
                 <br><br>
        <% } %>
        <br>
       <h3> <a href="home">Home</a></h3>

</body>
</html>
