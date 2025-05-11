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
  <title>408 Error - Request Timeout</title>
</head>
<body>
<c:import url="/navBar.jsp"/>
<div class="container">
  <div class="errorTitle">
    <h1><strong>408 - Request Timeout</strong></h1>
    <p>Your request took too long to complete, and the server closed the connection.</p>
  </div>

  <div class="errorReasons">
    <p>This could be because:</p>
    <ul class="errorList">
      <li>Your internet connection is slow or unstable</li>
      <li>The server is experiencing high traffic</li>
      <li>The request was left idle for too long</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Check your internet connection</li>
      <li>Try again in a few moments</li>
      <li>Contact support if the problem keeps happening</li>
    </ul>
  </div>
</div>
</body>
</html>