<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .meal-container{

        }

        .meal-content {
            display: block;
            width: auto;
            height: auto;
        }
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
            margin: 0;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        tr {
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        #meal_date {
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 100%;
            color: white;
            background-color: #007BFF;
        }

        #meal_date span {
            flex: 1;
            padding: 10px 0 10px 0;
        }

        #meal_date button {
            background-color: #007BFF;
            border: none;
        }

        #meal_date:hover {
            background-color: #3399FF;
        }

        #meal_date:hover button {
            background-color: #3399FF; !important;
        }

        #meal_date form {
            flex: 0;
        }

        .nutrition_progress, .meal_nutrition_facts {
            display: flex;
            flex-direction: column;
        }

        .nutrition_progress{

        }

        .meal_nutrition_facts td{
            border-bottom: 1px solid #ddd;
        }

        .meal_facts {
            border-bottom: 1px solid #ddd;
        }

        .meal_facts:hover {
            background-color: #f1f1f1;
        }

        /*CALENDAR*/

        .calendar {
            display: flex;
            justify-content: space-between;
            padding: 20px;
            gap: 10px;
        }

        .day {
            flex: 1;
            border: 1px solid black;
            text-align: center;
            cursor: pointer;
            box-sizing: border-box;
            min-width: 120px;
            height: 100%;
        }

        .day table {
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed;
        }

        .day th, .day td {
            padding: 8px;
            text-align: center;
            word-wrap: break-word;
            white-space: normal;
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
<div class="meal-container">
    <div class="meal-content">
        <h2>Your Meals</h2>
        <!-- Form -->
<%--        <form action="search-food" method="GET" id="searchFood">--%>
<%--            <div>--%>
<%--                <label for="searchTerm">Search by Food Name</label>--%>
<%--                <input type="text" id="searchTerm" name="searchTerm" value="${searchTerm}">--%>
<%--                <input type="submit" value="Submit">--%>
<%--            </div>--%>
<%--        </form>--%>

        <div class="calendar">
            <% for (String date : (List<String>) request.getAttribute("weekDates")) { %>
                <div class="day" onclick="">
                    <div id="meal_date">
                        <span> <%= date %></span>
                        <form action="search-food" method="POST" onsubmit="return confirmEdit()">
                            <input type="hidden" name="food_to_edit" value="${food.id}">
                            <input type="hidden" name="_method" value="EDIT">
                            <button type="submit" >
                                <img src="images/edit-white.svg" alt="edit" height="20px" width="20px">
                            </button>
                        </form>
                    </div>
                    <!-- Table for displaying search results -->
                    <table id="mealTable" class="display">
                        <tbody>
                        <tr id="" class="nutrition_progress">
                            <td>
                                <div>
                                    <span>Calories:</span>
                                    <span>1000/2191</span> cals
                                </div>
                            </td>
                            <td>
                                <div>
                                    <span>Protein:</span>
                                    <span>100/185</span> g
                                </div>
                            </td>
                            <td>
                                <div>
                                    <span>Carbs:</span>
                                    <span>150/256</span> g
                                </div>
                            </td>
                            <td>
                                <div>
                                    <span>Fat:</span>
                                    <span>25/54</span> g
                                </div>
                            </td>
                        </tr>

                        <tr class="meal_nutrition_facts">
                            <td>Breakfast</td>
                            <td class="meal_facts">
                                <div>
                                    <span>Whole Milk</span>
                                    <div>
                                        <span>8P</span>
                                        <span>12C</span>
                                        <span>8F</span>
                                    </div>
                                </div>
                                <div>1 Cup</div>
                            </td>
                            <td class="meal_facts">
                                <div>
                                    <span>Protein, MM</span>
                                    <div>
                                        <span>25P</span>
                                        <span>3C</span>
                                        <span>1.5F</span>
                                    </div>
                                </div>
                                <div>1 Scoop</div>
                            </td>
                        </tr>

                        <%--TEMPORARY! FIGURING OUT LAYOUT FIRST--%>
                        <%--            <c:forEach var="food" items="${foods}">--%>
                        <%--                <tr>--%>
                        <%--                    <td>Breakfast</td>--%>
                        <%--                    <td>--%>
                        <%--                        <div>--%>
                        <%--                            <span>Whole Milk</span>--%>
                        <%--                            <div>--%>
                        <%--                                <span>8P</span>--%>
                        <%--                                <span>12C</span>--%>
                        <%--                                <span>8F</span>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <%--                        <div>1 Cup</div>--%>
                        <%--                    </td>--%>
                        <%--                    <td>--%>
                        <%--                        <div>--%>
                        <%--                            <span>Protein, MM</span>--%>
                        <%--                            <div>--%>
                        <%--                                <span>25P</span>--%>
                        <%--                                <span>3C</span>--%>
                        <%--                                <span>1.5F</span>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <%--                        <div>1 Scoop</div>--%>
                        <%--                    </td>--%>
                        <%--                    <td>--%>
                        <%--                        <form action="search-food" method="POST" onsubmit="return confirmEdit()">--%>
                        <%--                            <input type="hidden" name="food_to_edit" value="${food.id}">--%>
                        <%--                            <input type="hidden" name="_method" value="EDIT">--%>
                        <%--                            <button type="submit">--%>
                        <%--                                <img src="images/" alt="edit" height="15px" width="15px">--%>
                        <%--                            </button>--%>
                        <%--                        </form>--%>
                        <%--                    </td>--%>
                        <%--                    <td>--%>
                        <%--                        <form action="search-food" method="POST" onsubmit="return confirmDelete()">--%>
                        <%--                            <input type="hidden" name="food_to_delete" value="${food.id}">--%>
                        <%--                            <input type="hidden" name="_method" value="DELETE">--%>
                        <%--                            <button type="submit">--%>
                        <%--                                <img src="images/trash-alt-svgrepo-com.svg" alt="delete" height="15px" width="15px">--%>
                        <%--                            </button>--%>
                        <%--                        </form>--%>
                        <%--                    </td>--%>
                        <%--                </tr>--%>
                        <%--            </c:forEach>--%>
                        </tbody>
                    </table>
                </div>
            <% } %>
        </div>
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
