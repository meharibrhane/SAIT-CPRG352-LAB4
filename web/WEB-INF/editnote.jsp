<%-- 
    Document   : editnote
    Created on : Jun 1, 2022, 12:47:30 PM
    Author     : mehari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note Keeper Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note?note" method="POST">
            <label>Title:</label>
            <input type="text" name="title" value="${note.title}">
            <br>
            <label>Contents:</label>
            <textarea name="contents" value="" row="7" cols="21">${note.contents}</textarea>
            <br><br>
            <input type="submit" value="save">
                 
        </form>
    </body>
</html>
