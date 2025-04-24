<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background: #fff;
            border-radius: 6px;
            overflow: hidden;
        }

        th {
            background: #007BFF;
            color: white;
            padding: 10px;
            text-align: left;
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        input {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }

        .submit-btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<c:import url="navBar.jsp" />
<div class="container">
    <h2>${title}</h2>
    <form action="edit-meal" method="POST">

        <!-- Food Information -->
        <table>
            <thead>
            <tr>
                <th colspan="2">Food Information</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Food Name</td>
                <label for="foodName">
                    <td><input id="foodName" type="text" name="foodName" value=${editMeal.foodName} required></td>
                </label>
            </tr>
            <tr>
                <td>Food Type</td>
                <label for="foodType">
                    <td><input id="foodType" type="text" name="foodType" value=${editMeal.foodType} required></td>
                </label>
            </tr>
            <tr>
                <td>Serving Size</td>
                <td>
                    <div style="display: flex; align-items: flex-start">
                        <label for="servingSize">
                            <input id="servingSize" type="text" name="servingSize" value=${editMeal.servingSize} required>
                            <input type="hidden" id="foodServingSize" data-nutrition="servings" value="${editMeal.servingSize}">
                        </label>

                        <label for="servingUnit">
                            <input id="servingUnit" type="text" name="servingUnit" value=${editMeal.servingUnit} required>
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Meal Time -->
        <table>
            <thead>
            <tr>
                <th colspan="2">Meal Time</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <label for="meal_times">
                    <td><select name="meal_times" id="meal_times" required>
                        <option value="breakfast" <c:if test="${editMeal.mealTime == 'breakfast'}">selected</c:if>>Breakfast</option>
                        <option value="lunch" <c:if test="${editMeal.mealTime == 'lunch'}">selected</c:if>>Lunch</option>
                        <option value="dinner" <c:if test="${editMeal.mealTime == 'dinner'}">selected</c:if>>Dinner</option>
                        <option value="snack" <c:if test="${editMeal.mealTime == 'snack'}">selected</c:if>>Snack</option>
                    </select></td>
                </label>
            </tr>
            </tbody>
        </table>

        <!-- Nutrition Information -->
        <table>
            <thead>
            <tr>
                <th colspan="2">Nutrition Information</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Calories (cals)</td>
                <td>
                    <label for="calories"></label>
                    <input id="calories" type="text" name="calories" value=${editMeal.totalCalories} required>
                    <input type="hidden" id="foodCalories" data-nutrition="calories" value="${editMeal.totalCalories}">
                </td>
            </tr>
            <tr>
                <td>Protein (g)</td>
                <td>
                    <label for="protein"></label>
                    <input id="protein" type="text" name="protein" value=${editMeal.totalProtein} required>
                    <input type="hidden" id="foodProtein" data-nutrition="protein" value="${editMeal.totalProtein}">
                </td>
            </tr>
            <tr>
                <td>Carbs (g)</td>
                <td>
                    <label for="carbs"></label>
                    <input id="carbs" type="text" name="carbs" value=${editMeal.totalCarbs} required>
                    <input type="hidden" id="foodCarbs" data-nutrition="carbs" value="${editMeal.totalCarbs}">

                </td>
            </tr>
            <tr>
                <td>Fat (g)</td>
                <td>
                    <label for="fat"></label>
                    <input id="fat" type="text" name="fat" value=${editMeal.totalFats} required>
                    <input type="hidden" id="foodFat" data-nutrition="fat" value="${editMeal.totalFats}">
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Submit Button -->
        <input type="hidden" name="food_to_edit" value="${editMeal.id}">
        <button type="submit" class="submit-btn">Submit</button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/mealUpdateScript.js"></script>
</body>
</html>
