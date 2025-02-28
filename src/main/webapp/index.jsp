<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<html>
<body>
    <h2>Macro Calculator</h2>
    <p>This calculator can help determine a person's macronutrient and Calorie needs under normal conditions.</p>
    <div class="cal-instructions">
        <img width="25" height="25" src="images/down-arrow.svg" alt="drop down arrow to change input units">
        <p>Modify the values and click the Calculate button to use.</p>
    </div>
    <div class="form-div">
        <form action="macro-results" method="GET" class="form">
            <table>
                <tbody>
                <tr>
                    <td width="78">Age</td>
                    <td width="372">
                        <input id="age" class="" type="text" name="age" value="25">
                        ages 18-80
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <label for="msex">
                            <input id="msex" type="radio" name="msex" value="f">
                            female
                        </label>

                        <label for="fsex">
                            <input id="fsex" type="radio" name="fsex" value="f">
                            female
                        </label>
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="container" id="height-container">
                <span>Height</span>
                <label for="feet">
                    <input type="text" id="feet" value="5">
                </label>
                    <span>feet</span>

                <label for="inches">
                    <input type="text" id="inches" value="10">
                </label>
                    <span>inches</span>
            </div>

            <div class="container" id="weight-container">
                <span>Weight</span>
                <label for="weight">
                    <input type="text" id="weight" name="weight" value="165">
                </label>
                    <span>pounds</span>
            </div>
            
            <div class="container" id="activity-container">
                <span>Activity</span>
                <label for="activity">
                    <select name="activity" id="activity">
                        <option value="1">Basal Metabolic Rate</option>
                        <option value="1.2">Sedentary: Little to no exercise </option>
                        <option value="1.375">Light: exercise 1–3 days/week</option>
                        <option value="1.465">Moderate: exercise 4–5 days/week</option>
                        <option value="1.55">Active: daily exercise or intense exercise 3–4 times/week</option>
                        <option value="1.725">Very Active: intense exercise 6–7 times/week</option>
                        <option value="1.9">Extra Active: very intense exercise daily, or physical job</option>
                    </select>
                </label>
            </div>

            <div class="container" id="goal-container">
                <span>Your Goal</span>
                <label for="goal">
                    <select name="goal" id="goal">
                        <option value="m">Maintain Weight</option>
                        <option value="l">Mild weight loss of 0.5 lb per week</option>
                        <option value="l1">Weight loss of 1 lb per week</option>
                        <option value="l2">Extreme weight loss of 2 lb per week</option>
                        <option value="g">Mild weight gain of 0.5 lb per week</option>
                        <option value="g1">Weight gain of 1 lb per week</option>
                        <option value="g2">Extreme weight gain of 2 lb per week</option>
                    </select>
                </label>
            </div>
        </form>
    </div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<html>
<body>
<h2>Macro Calculator</h2>
<p>This calculator can help determine a person's macronutrient and Calorie needs under normal conditions.</p>
<div class="cal-instructions">
    <img width="25" height="25" src="images/down-arrow.svg" alt="drop down arrow to change input units">
    <p>Modify the values and click the Calculate button to use.</p>
</div>
<div class="form-div">
    <form action="macro-results" method="GET" class="form">
        <table>
            <tbody>
            <tr>
                <td><label for="user-age">Age</label></td>
                <td>
                    <input type="text" id="user-age" name="age" value="25">
                    ages 18-80
                </td>
            </tr>
            <tr>
                <td><label for="sex1"></label>Gender</td>
                <td>
                    <input type="radio" id="sex1" name="sex1" value="m">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
