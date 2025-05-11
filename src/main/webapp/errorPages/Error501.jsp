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
  <title>501 Error - Not Implemented</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
  <div class="errorTitle">
    <h1><strong>501 Error - Not Implemented</strong></h1>
    <p>The server does not support the request method or functionality needed to complete your request.</p>
  </div>

  <div class="errorReasons">
    <p>This might happen because:</p>
    <ul class="errorList">
      <li>The feature is not available yet</li>
      <li>The request used an unsupported method</li>
      <li>There is a miscommunication between the client and server</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Double-check the URL or try a different action</li>
      <li>Contact support if you believe this feature should be available</li>
      <li>Return to the homepage</li>
    </ul>
  </div>
</div>
</body>
</html>