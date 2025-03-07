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
    <h2>Add Food</h2>
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
                    <label for="food_name"></label>
                    <td><input id="food_name" type="text" name="food_name" value="Ground Beef" required></td>
                </tr>
                <tr>
                    <td>Food Type</td>
                    <label for="food_type"></label>
                    <td><input id="food_type" type="text" name="food_type" value="Meat" required></td>
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
                            <input id="calories" type="text" name="calories" value="93" required>
                        </td>
                </tr>
                <tr>
                    <td>Protein (g)</td>
                    <td>
                        <label for="protein"></label>
                        <input id="protein" type="text" name="protein" value="4" required>
                    </td>
                </tr>
                <tr>
                    <td>Carbs (g)</td>
                    <td>
                        <label for="carbs"></label>
                        <input id="carbs" type="text" name="carbs" value="0" required>
                    </td>
                </tr>
                <tr>
                    <td>Fat (g)</td>
                    <td>
                        <label for="fat"></label>
                        <input id="fat" type="text" name="fat" value="8" required>
                    </td>
                </tr>
            </tbody>
        </table>

        <!-- Submit Button -->
        <button type="submit" class="submit-btn">Submit</button>
    </form>
</div>
</body>
</html>
