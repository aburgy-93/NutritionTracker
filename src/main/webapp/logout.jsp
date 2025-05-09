<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 700px !important;
      margin: 40px auto;
      padding: 20px;
      background: #ffffff;
      border-radius: 8px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    }

    div {
      display: flex;
      align-items: center;
      gap: 10px;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-bottom: 15px;
    }

    .login-url {
      margin-top: 10px;
    }
  </style>

</head>
<body>
<div class="container">
  <h2>You Have Logged Out Successfully</h2>

  <c:choose>
    <c:when test="${empty userName}">
      <div class="login-url">
        <a href="logIn">Log in</a>
      </div>
    </c:when>
  </c:choose>
</div>

</body>

</html>
