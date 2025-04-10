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
    <title>Test</title>
</head>
<body>
    <c:import url="navBar.jsp" />

    <div class="container">
        <div class="content">
            <form action="search" method="get" id="searchFoods">
                <div>
                    <label for="search">Search by Food Name</label>
                    <input type="text" id="search" name="search" value="${search}">
                    <input type="submit" value="Submit">
                </div>
            </form>

            <table id="searchFoodTable" class="display">
                <thead>
                   <tr>
                       <th>Food Name</th>
                       <th>Food ID</th>
                   </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.title}</td>
                        <td>${product.id}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty products}">
                    <tr>
                        <td colspan="2">No results found. Try another search.</td>
                    </tr>
                </c:if>

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
