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
    <title>Exception Error</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
    <div class="errorTitle">
        <h1>We are sorry: an unexpected error has occurred.</h1>
    </div>
    <div class="errorReasons">
        <p>Please try the following:</p>
        <ul class="errorList">
            <li>Go back and try again</li>
            <li>Refresh the page</li>
            <li>Contact support if the problem persists</li>
        </ul>
    </div>
</div>
</body>
</html>