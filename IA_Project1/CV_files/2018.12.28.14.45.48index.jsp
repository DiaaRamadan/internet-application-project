<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="sendMail">
            To:<input type="text" name="to">
            <br>
            <br>
            subject: <input type="text" name="subject">
            <br>
            <br>
            Massage:
            <br>
            <br>
            <textarea name="massage" rows="6" cols="50"></textarea>
            <br>
            <br>
            <input type="submit" value="send">
        </form>
    </body>
</html>