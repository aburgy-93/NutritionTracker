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
  <title>400 Bad Request</title>
</head>
<body>
<c:import url="/navBar.jsp"/>
<div class="container">
  <div class="errorTitle">
    <h1><strong>400 - Bad Request</strong></h1>
    <p>The server could not understand your request.</p>
  </div>

  <div class="errorReasons">
    <p>This could be because:</p>
    <ul class="errorList">
      <li>Invalid or incomplete form data</li>
      <li>A malformed request URL</li>
      <li>Unsupported characters or encoding issues</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Double-check the information you entered</li>
      <li>Refresh the page and try again</li>
      <li>Contact support if the issue continues</li>
    </ul>
  </div>
</div>
</body>
</html>