<%@page import="com.example.MappingOneToMany.Entity.Courses" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<center>
    <h2>Add Course</h2>
    <form action="addResultCourses">
        <label for="courseId">Course Id:</label><br>
        <input type="number" id="courseId" name="courseId" required><br>

        <label for="courseName">Course Name:</label><br>
        <input type="text" id="courseName" name="courseName" required><br>

        <label for="courseGuide">Course Guide:</label><br>
        <input type="text" id="courseGuide" name="courseGuide" required><br><br>

         <label for="student">Student Id to Assign:</label><br>
          <input type="text" id="student" name="student" required><br><br>


        <input type="submit" value="Submit">
    </form>
           <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
