<%@page import="com.example.MappingOneToMany.Entity.Courses" %>
<%@page import="com.example.MappingOneToMany.Entity.Student" %>

<html>
<head>
    <title>Employee Details</title>

</head>
<body>
    <center>
        <%
                Courses s = (Courses) request.getAttribute("course");
            if (s!=null) {
            Student s1=s.getStudent();
        %>
            <h2>Course Details Successfully Added</h2>
              <table>
            <tr>
                <th>Course Name</th>
                <td>${course.courseName}</td>
            </tr>
            <tr>
                <th>Course Id</th>
                <td>${course.courseId}</td>
            </tr>
            <tr>
                <th>SCourse Guide</th>
                <td>${course.courseGuide}</td>
            </tr>
             <tr>
                    <th>Student Id</th>
                   <td><%= s1.getId() %></td>
            </tr>

        </table>
            <br>

        <% } else { %>
            <h2>The Course is Already Assigned to a Student</h2>

                 <br><br>
        <% } %>
        <br>
        <h3><a href="addCourses">Add other Courses</a></h3>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
