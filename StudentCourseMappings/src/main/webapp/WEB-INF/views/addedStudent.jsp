<%@ page import="com.SpringProject.StudentCourseMappings.Entity.Student" %>
<%@page language="java" %>
<html>
<head>
    <title>Add Student</title>

</head>
    <body>
    <%
        Student student= (Student) request.getAttribute("addStudent");

        if(student==null){
    %>
        <h1>Student Details</h1>
        <form action="addStudentDone">
            <label for="sid"> Enter Id : </label>
            <input type="number" id="sid" name="sid">
            <br>
            <label for="sname">Enter Name : </label>
            <input type="text" id="sname" name="sname" required>
            <br>
            <label for="srollno">Enter RolL No : </label>
            <input type="text" id="srollno" name="srollno" required>
            <br>
            <label for="sclass"> Enter Class : </label>
            <input type="text" id="sclass" name="sclass" required>
            <br>

            <label for="cid"> Enter Course id : </label>
            <input type="text" id="cid" name="cid" required>
                                          <br>
             <label for="cname"> Enter Course name: </label>
                        <input type="text" id="cname" name="cname" required>
                                                      <br>
              <label for="cdept"> Enter Course dept : </label>
                         <input type="text" id="cdept" name="cdept" required>
                                                       <br>
            <input type="submit" value="Add Student">
        </form>
    <% } else { %>
        <h1> Student Sid ${studentSid} Already Exists </h1>
    <% } %>
    <form action="/home">
        <input type="submit" value="Go to Home Page">
    </form>
    </body>
</html>