<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>

    <title>All Student Details</title>
</head>
<body>
<h1>Student Details</h1>
    <form action="searchStudentDone">
        <label for="sid" >Student Id :</label>
        <input type="text" id="sid"  name="sid">
        <input type="submit" value="Search">
    </form>
    <form action="/home">
        <input type="submit" value="Go to Home Page">
    </form>
</body>
</html>
