<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/head.jsp" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>403 Error - Forbidden</title>
</head>
<body>
<c:import url="/navBar.jsp"/>
<div style="text-align: center;">
  <h1><strong>403 - Forbidden</strong></h1>
  <p>You do not have permission to access this page or resource.</p>
</div>

<div style="text-align: center;">
  <p>This might be because:</p>
  <ul>
    <li>Your account does not have the required permissions</li>
    <li>Access to this resource is restricted</li>
    <li>You are trying to perform an action you are not authorized for</li>
  </ul>

  <p>What you can do:</p>
  <ul>
    <li>Return to the homepage</li>
    <li>Contact support if you believe this is an error</li>
  </ul>
</div>
</body>
</html>