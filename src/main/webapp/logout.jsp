<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<head>

</head>
<body>
<h2>You Have Logged Out Successfully</h2>

<c:choose>
  <c:when test="${empty userName}">
    <a href="logIn">Log in</a>
  </c:when>
  <c:otherwise>
    <p>Welcome back, ${userName}!</p>
  </c:otherwise>
</c:choose>
</body>

</html>
