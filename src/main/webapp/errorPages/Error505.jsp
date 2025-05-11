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
  <title>505 Error - HTTP Version Not Supported</title>
</head>
<body>
<c:import url="/errorNav.jsp" />
<div class="container">
  <div class="container">
    <h1><strong>505 Error - HTTP Version Not Supported</strong></h1>
    <p>The server does not support the HTTP version used in the request.</p>
  </div>

  <div class="errorReasons">
    <p>This may be due to:</p>
    <ul class="errorList">
      <li>An outdated or incompatible client</li>
      <li>A misconfigured request</li>
      <li>Use of a deprecated protocol version</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Try using a different browser or updating your current one</li>
      <li>Contact support if you're unsure how to resolve this</li>
    </ul>
  </div>
</div>
</body>
</html>