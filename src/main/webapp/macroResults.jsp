<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/errors.css">
</head>
<body>
  <c:import url="navBar.jsp" />
  <div class="container">
      <div class="content">
          <h2>${title}</h2>
          <table id="results-table">
              <tbody>
              <tr>
                  <td class="title-box">Protein</td>
                  <td class="results-box">${results.Protein} grams/day</td>
              </tr>
              <tr>
                  <td class="title-box">Carbs</td>
                  <td class="results-box">${results.Carbohydrate} grams/day</td>
              </tr>
              <tr>
                  <td class="title-box">Fat</td>
                  <td class="results-box">${results.Fats} grams/day</td>
              </tr>
              <tr>
                  <td class="title-box">Calories</td>
                  <td class="results-box">${results.Calories} Calories/day</td>
              </tr>
              </tbody>
          </table>
      </div>
  </div>
</body>
</html>
