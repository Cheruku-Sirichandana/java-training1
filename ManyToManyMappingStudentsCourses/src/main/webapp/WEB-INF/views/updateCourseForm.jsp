
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<center>
    <h2>Add Course</h2>
    <form action="updateCourseResult">
        <label for="cid">Course Id:</label><br>
        <input type="number" id="cid" name="cid" value="${cid}" readonly><br>

        <label for="cname">Course Name:</label><br>
        <input type="text" id="cname" name="cname" required><br>

        <label for="cdept">Course Guide:</label><br>
        <input type="text" id="cdept" name="cdept" required><br><br>

        <input type="submit" value="Submit">
    </form>
    <h3> <a href="home">Home</a></h3>

</center>
</body>
</html>