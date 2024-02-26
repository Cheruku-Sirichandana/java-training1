
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
</head>
<body>

    <h2>Enter Course Id Here</h2>
    <form action="AddCoursesToStudentResult">
       <input type="hidden" id="sid" name="sid" value="${sid}"><br>

        <label for="cid">Course Id:</label><br>
        <input type="number" id="cid" name="cid" required><br>


        <input type="submit" value="Submit">
    </form>
           <h3> <a href="home">Home</a></h3>


</body>
</html>
