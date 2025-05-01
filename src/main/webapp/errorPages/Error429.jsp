<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/head.jsp" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>429 Error - Too Many Requests</title>
</head>
<body>
<c:import url="/navBar.jsp"/>
<div style="text-align: center;">
  <h1><strong>429 - Too Many Requests</strong></h1>
  <p>You have made too many requests in a short period of time.</p>
  <p>To protect our servers and ensure fair use, we temporarily limit the number of requests you can make.</p>
</div>

<div style="text-align: center;">
  <p>What you can do:</p>
  <ul>
    <li>Wait a moment, then try again</li>
    <li>Avoid refreshing or resubmitting repeatedly</li>
    <li>Contact support if you believe this is a mistake</li>
  </ul>
</div>
</body>
</html>