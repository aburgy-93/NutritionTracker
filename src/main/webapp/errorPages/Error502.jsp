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
  <title>502 Error - Bad Gateway</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
  <div class="errorTitle">
    <h1><strong>502 Error - Bad Gateway</strong></h1>
    <p>There was a problem connecting to the server.</p>
    <p>Our servers were unable to complete your request due to a communication issue with another server.</p>
  </div>

  <div class="errorReasons">
    <p>What you can do:</p>
    <ul class="errorList">
      <li>Refresh the page and try again</li>
      <li>Wait a moment and try later</li>
      <li>Contact support if the problem persists</li>
    </ul>

    <p>We are working to resolve the issue as quickly as possible. Thanks for your patience.</p>
  </div>
</div>
</body>
</html>