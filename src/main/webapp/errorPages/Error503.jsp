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
  <title>503 Error - Service Unavailable</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
  <div class="errorTitle">
    <h1><strong>503 Error - Service Unavailable</strong></h1>
    <p>The service is temporarily unavailable.</p>
  </div>

  <div class="errorReasons">
    <p>This may be due to:</p>
    <ul class="errorList">
      <li>Scheduled maintenance</li>
      <li>Server overload or downtime</li>
      <li>A temporary issue with our systems</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Try again in a few minutes</li>
      <li>Return to the homepage</li>
      <li>Contact support if the problem continues</li>
    </ul>

    <p>We are working to restore service as quickly as possible. Thank you for your patience.</p>
  </div>
</div>
</body>
</html>