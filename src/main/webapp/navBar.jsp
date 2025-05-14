<nav class="topnav">
    <div class="nav-wrapper">
        <div class="navLinks">
            <div class="homepageLink">
                <a href="/NutritionTracker_war/">Food Tracker</a>
            </div>
            <div class="links-div">
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
        </div>

        <div class="user-info">
            <c:choose>
                <c:when test="${empty user}"></c:when>
                <c:otherwise>
                    <span>Welcome ${user.username}</span>
                    <a href="logOut">Log Out</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

