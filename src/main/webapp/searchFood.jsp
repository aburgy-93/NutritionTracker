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
            gap: 15px;
            justify-content: space-between;
            flex-wrap: nowrap;
            width: 100%;
        }

        /* Ensure the input and label are aligned properly */
        form div {
            display: flex;
            align-items: center;
            gap: 10px;
            width: 100%;
        }

        /* Form input field */
        input[type="text"] {
            padding: 8px 12px;
            margin: 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            width: 350px;
        }

        /* Submit button styling */
        input[type="submit"] {
            padding: 8px 16px;
            font-size: 14px;
            cursor: pointer;
            margin-left: auto;
            width: 200px
        }

        /* Label styling */
        label {
            margin-right: 10px;
            font-size: 14px;
            white-space: nowrap;
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
                flex-direction: column;
                align-items: stretch;
            }

            input[type="text"] {
                width: 100%;
            }

            .submit-btn, .clear-btn {
                width: 100%;
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
                <th></th>
                <th></th>
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
                        <td>
                            <form action="search-food" method="POST" onsubmit="return confirmEdit()">
                                <input type="hidden" name="food_to_edit" value="${food.id}">
                                <input type="hidden" name="_method" value="EDIT">
                                <button type="submit">
                                    <img src="images/edit-svgrepo-com.svg" alt="edit" height="15px" width="15px">
                                </button>
                            </form>
                        </td>
                        <td>
                            <form action="search-food" method="POST" onsubmit="return confirmDelete()">
                                <input type="hidden" name="food_to_delete" value="${food.id}">
                                <input type="hidden" name="_method" value="DELETE">
                                <button type="submit">
                                    <img src="images/trash-alt-svgrepo-com.svg" alt="delete" height="15px" width="15px">
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
    <script>
        function confirmDelete() {
            return confirm("Are you sure you want to delete this food item?");
        }

        function confirmEdit() {
            return confirm("Are you sure you want to edit this food item?");
        }
    </script>
</html>
