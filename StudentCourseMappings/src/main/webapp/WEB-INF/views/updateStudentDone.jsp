<%@ page import="com.SpringProject.StudentCourseMappings.Entity.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>

    <title>All Student Details</title>
</head>
<body>
    <%
        Student updateStudent = (Student) request.getAttribute("updateStudent");
    %>
    <div>
        <%
            if (updateStudent!= null) {
        %>
        <form action="updateStudentSuccessfully">
            <h1>Enter Student Details</h1>
            <br>
            <label for="sid">Student Id : </label>
            <input type="text" id="sid" name="sid" value=${sid}  readonly>
            <br>
            <label for="sname">Enter Name : </label>
            <input type="text" id="sname" name="sname" required>
            <br>
            <label for="srollno">Enter Roll No : </label>
            <input type="text" id="srollno" name="srollno" required>
            <br>
            <label for="sclass"> EnterClass : </label>
                        <input type="text" id="sclass" name="sclass" required>
                        <br>
            <label for="cid"> Enter course Id : </label>
                                                <input type="number" id="cid" name="cid" required>
                                                <br>
             <label for="cname"> EnterCourse name: </label>
                              <input type="text" id="cname" name="cname" required>
                                                                        <br>
                <label for="cdept"> Enter Course dept: </label>
                                 <input type="text" id="cdept" name="cdept" required>
                                                                                                <br>
            <input type="submit" value="Update">
        </form>
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
