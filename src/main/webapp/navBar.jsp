<nav class="topnav">
    <a href="/NutritionTracker_war/">Food Tracker</a>
    <div>
        <ul class="links">
            <li>
                <a href="#">Profile</a>
            </li>
            <li>
                <a href="search-food">Search Foods</a>
            </li>
            <li>
                <a href="meal-display">Your Meals</a>
            </li>
            <li>
                <a href="add-meal">Add a Meal</a>
            </li>
            <li>
                <a href="add-food">Add Food</a>
            </li>
        </ul>
    </div>
    <c:choose>
        <c:when test="${empty userName}">
            <a href = "logIn">Log in</a>
        </c:when>
        <c:otherwise>
            <h3>Welcome ${userName}</h3>
        </c:otherwise>
    </c:choose>
</nav>

