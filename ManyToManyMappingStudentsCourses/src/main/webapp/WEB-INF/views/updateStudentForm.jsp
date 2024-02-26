
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

    <h2>Add Student</h2>
    <form action="updateStudentResult">
        <label for="sid">Student ID:</label><br>
        <input type="text" id="sid" name="sid" value="${sid}" readonly><br>

        <label for="sname">Name:</label><br>
        <input type="text" id="sname" name="sname" required><br>

        <label for="sclass">Class:</label><br>
        <input type="text" id="sclass" name="sclass" required><br><br>

        <input type="submit" value="Submit" required>
    </form>
           <h3> <a href="home">Home</a></h3>


</body>
</html>