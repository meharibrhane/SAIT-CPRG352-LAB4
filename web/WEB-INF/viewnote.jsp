

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple NOte Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
            <div>
                <p><strong>Title:</strong>${note.title}</p>
                <p><strong>Contents:</strong>${note.contents}</p>
            </div>
          
        <a href="note?edit">Edit</a>
    </body>
</html>
