<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yahoo Fom JSP!!!!!!!!</title>
    </head>

    <%
        System.out.println("Dummy");
        String n = request.getParameter("name");
        System.out.println(n);
        Date date = new Date();
    %>

    <body>
        My First JSP ${name}
        <p><%=date%></p>
        <br />

        <form action="/login.do" method="post">
            <p>Enter your user: <input type="text" name="user" /></p>
            <p>Password: <input type="password" name="password" /></p>
            <p><input type="submit" value="Login" /></p>
        </form>

        <p>${errorMessage}</p>

    </body>
</html>
