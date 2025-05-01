<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/head.jsp" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>405 Error - Method Not Allowed</title>
</head>
<body>
<c:import url="/navBar.jsp"/>
<div style="text-align: center;">
  <h1><strong>405 - Method Not Allowed</strong></h1>
  <p>The request method you used is not allowed for this resource.</p>
</div>

<div style="text-align: center;">
  <p>This can happen when:</p>
  <ul>
    <li>You tried to use an unsupported method (e.g., sending a POST request to a read-only endpoint)</li>
    <li>There is a misconfiguration in the client or API call</li>
  </ul>

  <p>What you can do:</p>
  <ul>
    <li>Check the request method and try again</li>
    <li>Return to the homepage or use the navigation menu</li>
    <li>Contact support if you believe this is a mistake</li>
  </ul>
</div>
</body>
</html>