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
  <title>401 Unauthorized</title>
</head>
<body>
<c:import url="/navBar.jsp" />
<div class="container">
  <div class="errorTitle">
    <h1><strong>401 - Access Denied</strong></h1>
    <p>You are not authorized to view this page or perform this action.</p>
  </div>

  <div class="errorReasons">
    <p>This could be because:</p>
    <ul class="errorList">
      <li>You're not logged in</li>
      <li>Your session has expired</li>
      <li>You do not have permission to access this resource</li>
    </ul>

    <p>What you can do:</p>
    <ul class="errorList">
      <li>Log in to your account</li>
      <li>Contact support if you believe this is a mistake</li>
    </ul>
  </div>
</div>
</body>
</html>