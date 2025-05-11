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
    <title>Unable to Load the Requested Resource</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
    <div class="errorTitle">
        <h1>We are sorry: there was a problem retrieving the information you requested.</h1>
    </div>
    <div class="errorReasons">
        <p><strong>This might be due to:</strong></p>
        <ul class="errorList">
            <li>A temporary server or network issue</li>
            <li>A missing or inaccessible file</li>
            <li>A timeout or interrupted connection</li>
        </ul>

        <p><strong>What you can do:</strong></p>
        <ul class="errorList">
            <li>Try again in a few moments</li>
            <li>Check your internet connection (if applicable)</li>
            <li>Contact support if this keeps happening</li>
        </ul>
    </div>
</div>
</body>
</html>