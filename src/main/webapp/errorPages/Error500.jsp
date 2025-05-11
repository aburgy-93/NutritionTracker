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
  <title>500 Error - Server Error</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
  <div class="errorTitle">
    <h1><strong>500 Error - Server Error</strong></h1>
    <p>Oops! Something went wrong on our end.</p>
    <p>The server encountered an unexpected error and could not complete your request.</p>
  </div>

  <div class="errorReasons">
    <p>What you can do:</p>
    <ul class="errorList">
      <li>Try again in a few moments</li>
      <li>Go back to the homepage</li>
      <li>Contact support if the issue continues</li>
    </ul>

    <p>We are working to fix the problem as quickly as possible. Thank you for your patience.</p>
  </div>
</div>
</body>
</html>