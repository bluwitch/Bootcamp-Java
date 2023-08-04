<%-- 
    Document   : index
    Created on : 3 Aug 2023, 16:32:17
    Author     : Martu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Project</title>
    </head>
    <body>
        <h1>User Info</h1>
        <form action="Home" method="POST">
            <p><label>Name: </label><input type="text" name="name"></p>
            <p><label>Surname: </label><input type="text" name="surname"></p>
            <p><label>Favorite Language: </label><input type="text" name="language"></p>
            <p><label>Hometown: </label><input type="text" name="hometown"></p>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>