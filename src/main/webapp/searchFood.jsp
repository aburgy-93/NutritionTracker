<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <c:import url="navBar.jsp" />
    <div class="container">
        <h2>Search for Foods</h2>

        <form action="search-food" method="GET">
            <label for="searchTerm">Search by Food Name</label>
            <input type="text" id="searchTerm" name="searchTerm" value="${searchTerm}">
            <input type="submit" value="Submit">
        </form>

        <table id="foodTable" class="">
            <thead>
                <th>Food Name</th>
                <th>Food Type</th>
                <th>Serving Size</th>
                <th>Serving Type</th>
                <th>Calories</th>
                <th>Protein</th>
                <th>Carbs</th>
                <th>Fat</th>
            </thead>
            <tbody>
                <c:forEach var="food" items="${foods}">
                    <tr>
                        <td>${food.foodName}</td>
                        <td>${food.foodType}</td>
                        <td>${food.servingSize}</td>
                        <td>${food.servingUnit}</td>
                        <td>${food.calories}</td>
                        <td>${food.protein}</td>
                        <td>${food.carbs}</td>
                        <td>${food.fat}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
