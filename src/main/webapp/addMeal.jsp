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
    <form action="search-food" method="POST">

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
                <label for="food_name">
                    <td><input id="food_name" type="text" name="food_name" value=${foodToAdd.foodName} required></td>
                </label>
            </tr>
            <tr>
                <td>Food Type</td>
                <label for="food_type">
                    <td><input id="food_type" type="text" name="food_type" value=${foodToAdd.foodType} required></td>
                </label>
            </tr>
            <tr>
                <td>Serving Size</td>
                <td>
                    <div style="display: flex; align-items: flex-start">
                        <label for="servings">
                            <input id="servings" type="text" name="servings" value=${foodToAdd.servingSize} required>
                        </label>

                        <label for="serving_units">
                            <input id="serving_units" type="text" name="serving_units" value=${foodToAdd.servingUnit} required>
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
                    <input id="calories" type="text" name="calories" value=${foodToAdd.calories} required>
                </td>
            </tr>
            <tr>
                <td>Protein (g)</td>
                <td>
                    <label for="protein"></label>
                    <input id="protein" type="text" name="protein" value=${foodToAdd.protein} required>
                </td>
            </tr>
            <tr>
                <td>Carbs (g)</td>
                <td>
                    <label for="carbs"></label>
                    <input id="carbs" type="text" name="carbs" value=${foodToAdd.carbs} required>
                </td>
            </tr>
            <tr>
                <td>Fat (g)</td>
                <td>
                    <label for="fat"></label>
                    <input id="fat" type="text" name="fat" value=${foodToAdd.fat} required>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Submit Button -->
        <input type="hidden" name="_method" value="ADD_MEAL">
<%--        <button type="submit" class="submit-btn">Submit</button>--%>
    </form>
</div>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const serving = document.getElementById("servings");
            const calories = document.getElementById("calories");
            const protein = document.getElementById("protein");
            const carbs = document.getElementById("carbs");
            const fat = document.getElementById("fat");

            // Ensure JSP values are properly converted to JavaScript Numbers
            let originalServingSize = parseFloat(${foodToAdd.servingSize}) || 1;
            let originalCalories = parseFloat(${foodToAdd.calories}) || 0;
            let originalProtein = parseFloat(${foodToAdd.protein}) || 0;
            let originalCarbs = parseFloat(${foodToAdd.carbs}) || 0;
            let originalFat = parseFloat(${foodToAdd.fat}) || 0;

            serving.addEventListener("input", function () {
                let newServingSize = parseFloat(serving.value) || 1;

                if (!isNaN(newServingSize) && originalServingSize > 0) {
                    calories.value = ((newServingSize / originalServingSize) * originalCalories).toFixed(2);
                    protein.value = ((newServingSize / originalServingSize) * originalProtein).toFixed(2);
                    carbs.value = ((newServingSize / originalServingSize) * originalCarbs).toFixed(2);
                    fat.value = ((newServingSize / originalServingSize) * originalFat).toFixed(2);
                }
            })
        })
    </script>
</body>
</html>
