<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/head.jsp" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/errors.css">
    <title>404 Error - Page Not Found</title>
</head>
<body>
<c:import url="/navBar.jsp" />
<div class="container">
    <div class="errorTitle">
        <h1><strong>404 - Page Not Found</strong></h1>
        <p>Sorry, the page you requested was not found.</p>
    </div>

    <div class="errorReasons">
        <p>This could be because:</p>
        <ul class="errorList">
            <li>The page was moved or deleted</li>
            <li>You typed the address incorrectly</li>
            <li>The link you followed is broken</li>
        </ul>

        <p>Here are some helpful options:</p>
        <ul class="errorList">
            <li>Go back to the homepage</li>
            <li>Use the menu to navigate</li>
            <li>Contact support if this error continues</li>
        </ul>
    </div>
</div>
</body>
</html>