<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        /* Flexbox for form layout */
        form {
            display: flex;
            align-items: center;
            gap: 15px; /* Space between elements */
            justify-content: space-between; /* Distribute items and push the submit button to the right */
            flex-wrap: nowrap; /* Prevent wrapping */
            width: 100%; /* Ensure the form takes up the full width */
        }

        /* Ensure the input and label are aligned properly */
        form div {
            display: flex;
            align-items: center;
            gap: 10px;
            width: 100%; /* Ensure the div spans the full width */
        }

        /* Form input field */
        input[type="text"] {
            padding: 8px 12px;
            margin: 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            width: 350px; /* Fixed width for the search box */
        }

        /* Submit button styling */
        input[type="submit"] {
            padding: 8px 16px; /* Smaller padding for half-size button */
            font-size: 14px; /* Smaller text for the button */
            cursor: pointer;
            margin-left: auto; /* Push the button to the right */
            width: 200px
        }

        /* Label styling */
        label {
            margin-right: 10px;
            font-size: 14px;
            white-space: nowrap; /* Prevent the label from wrapping */
        }

        /* Table styling for food results */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        @media screen and (max-width: 768px) {
            form {
                flex-direction: column; /* Stack the form elements vertically on smaller screens */
                align-items: stretch; /* Stretch elements to full width */
            }

            input[type="text"] {
                width: 100%; /* Full width for input on small screens */
            }

            .submit-btn, .clear-btn {
                width: 100%; /* Full width for buttons on small screens */
            }
        }
    </style>
</head>
<body>
<c:import url="navBar.jsp" />
<div class="container">
    <div class="content">
        <h2>Search for Foods</h2>
        <!-- Form -->
        <form action="search-food" method="GET" id="searchFood">
            <div>
                <label for="searchTerm">Search by Food Name</label>
                <input type="text" id="searchTerm" name="searchTerm" value="${searchTerm}">
                <input type="submit" value="Submit">
            </div>
        </form>

        <!-- Table for displaying search results -->
        <table id="foodTable" class="display">
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
</div>
</body>
</html>
