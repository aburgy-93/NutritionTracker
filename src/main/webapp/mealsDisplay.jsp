<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="head.jsp" />

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

        .weekButtons{
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #previousButton{
            margin-right: 18px;
        }

        #nextButton{

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
            table-layout: fixed;
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

        .meal_table {
            width: 100%;
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
            display: flex;
            border-bottom: 1px solid #ddd;
            padding-left: 10px;
        }

        .meal_facts:hover {
            background-color: #f1f1f1;
        }

        .meal_facts td {
            display: flex;
            flex-direction: column;
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
            min-width: 160px;
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
        <h2>${title}</h2>
            <%
                int currentOffSet = (Integer) request.getAttribute("weekOffSet");
            %>
            <div class="weekButtons">
                <button id="previousButton">
                    <a href="http://localhost:8080/NutritionTracker_war/meal-display?weekOffSet=<%= currentOffSet - 1 %>">&lArr; Previous Week</a>
                </button>

                <button id="nextButton">
                    <a href="http://localhost:8080/NutritionTracker_war/meal-display?weekOffSet=<%= currentOffSet + 1 %>">Next Week &rArr;</a>
                </button>
            </div>
        <div class="calendar">
            <c:forEach var="i" begin="0" end="${fn:length(weekDates) - 1}">
                <c:set var="displayDate" value="${weekDates[i]}" />
                <c:set var="isoDate" value="${isoWeekDates[i]}" />

                <div class="day">
                    <div id="meal_date">
                        <span>${displayDate}</span>
                        <form action="search-food" method="POST" onsubmit="return confirmEdit()">
                            <input type="hidden" name="food_to_edit" value="${food.id}">
                            <input type="hidden" name="_method" value="EDIT">
                            <button type="submit">
                                <img src="images/edit-white.svg" alt="edit" height="20px" width="20px">
                            </button>
                        </form>
                    </div>

                    <!-- Meal Table for each day -->
                    <table class="meal_table">
                        <tbody>
                        <c:forEach var="entry" items="${meals}">
                            <c:set var="mealTime" value="${entry.key}" />
                            <c:set var="hasMealsForThisDay" value="false"/>
                            <c:forEach var="mealItem" items="${entry.value}">
                                <c:if test="${mealItem.date == isoDate}">
                                    <c:if test="${!hasMealsForThisDay}">
                                            <td colspan="4"><strong>${mealTime}</strong></td>
                                        <c:set var="hasMealsForThisDay" value="true" />
                                    </c:if>

                                    <tr class="meal_facts">
                                        <td>
                                            ${mealItem.totalProtein}
                                            <span>Protein</span>
                                        </td>
                                        <td>
                                            ${mealItem.totalCarbs}
                                            <span>Carbs</span>
                                        </td>
                                        <td>
                                            ${mealItem.totalFats}
                                            <span>Fat</span>
                                        </td>
                                        <td>
                                            ${mealItem.totalCalories}
                                            <span>Cals</span>
                                        </td>
<%--                                        <td>--%>
<%--                                            <form action="edit-meal" method="POST">--%>
<%--                                                <input type="hidden" name="mealId" value="${mealItem.id}" />--%>
<%--                                                <button type="submit">Edit</button>--%>
<%--                                            </form>--%>
<%--                                        </td>--%>
<%--                                        <td>--%>
<%--                                            <form action="delete-meal" method="POST" onsubmit="return confirmDelete()">--%>
<%--                                                <input type="hidden" name="mealId" value="${mealItem.id}" />--%>
<%--                                                <button type="submit">Delete</button>--%>
<%--                                            </form>--%>
<%--                                        </td>--%>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:forEach>
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
