<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yahoo Fom JSP!!!!!!!!</title>
    </head>

    <body>
        My First JSP ${name}
        <br />

        <form action="/spring-mvc/login" method="post">
            <p>Enter your user: <input type="text" name="user" /></p>
            <p>Password: <input type="password" name="password" /></p>
            <p><input type="submit" value="Login" /></p>
        </form>

        <p>${errorMessage}</p>

    </body>
</html>
