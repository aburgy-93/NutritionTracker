<nav class="topnav">
    <a href="/NutritionTracker_war/">Food Tracker</a>
    <div style="display: flex; justify-content: space-between">
        <div>
            <ul class="links">
                <li>
                    <a href="#">Profile</a>
                </li>
                <li>
                    <a href="search-food">Search Your Foods</a>
                </li>
                <li>
                    <a href="search">Search Foods</a>
                </li>
                <li>
                    <a href="meal-display">Your Meals</a>
                </li>
                <li>
                    <a href="add-food">Add Food</a>
                </li>
            </ul>
        </div>
        <div>
            <c:choose>
                <c:when test="${empty userName}">

                </c:when>
                <c:otherwise>
                    <h3 style="color: white; margin-right: 22px; margin-bottom: 20px">Welcome ${userName}</h3>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

