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
  <title>504 Error - Gateway Timeout</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
  <div class="errorTitle">
    <h1><strong>504 Error - Gateway Timeout</strong></h1>
    <p>The server took too long to respond.</p>
  </div>

  <div class="errorReasons">
    <p>This can happen when:</p>
    <ul class="errorList">
      <li>The upstream server is down or slow to respond</li>
      <li>There is heavy network traffic</li>
      <li>A timeout occurred between server components</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Refresh the page or try again shortly</li>
      <li>Check your internet connection</li>
      <li>Contact support if the issue continues</li>
    </ul>

    <p>We are aware of the issue and working to fix it as quickly as possible.</p>
  </div>
</div>
</body>
</html>