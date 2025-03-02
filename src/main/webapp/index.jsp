<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<html>
<body>
    <div class="container">
        <div class="content">
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
                                <label for="age">
                                    <input id="age" class="" type="text" name="age" value="25" required>
                                </label>
                                ages 18-80
                            </td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td>
                                <label for="msex">
                                    <input id="msex" type="radio" name="gender" value="m">
                                    male
                                </label>

                                <label for="fsex">
                                    <input id="fsex" type="radio" name="gender" value="f">
                                    female
                                </label>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <table>
                        <tbody>
                        <tr>
                            <td width="78">Height</td>
                            <td width="372">
                                <table>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <label for="heightFeet">
                                                <input type="text" id="heightFeet" name="heightFeet" value="5" required>
                                                <span>feet</span>
                                            </label>
                                        </td>
                                        <td></td>
                                        <td>
                                            <label for="heightInches">
                                                <input type="text" id="heightInches" name="heightInches" value="10" required>
                                                <span>inches</span>
                                            </label>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>Weight</td>
                            <td>
                                <label for="weight">
                                    <input type="text" id="weight" name="weight" value="165" required>
                                    <span>pounds</span>
                                </label>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <table>
                        <tbody>
                        <tr>
                            <td width="80">Activity</td>
                            <td width="500">
                                <label for="activity">
                                    <select name="activity" id="activity" required>
                                        <option value="1">Basal Metabolic Rate</option>
                                        <option value="1.2">Sedentary: Little to no exercise </option>
                                        <option value="1.375">Light: exercise 1-3 days/week</option>
                                        <option value="1.465">Moderate: exercise 4-5 days/week</option>
                                        <option value="1.55">Active: daily exercise or intense exercise 3-4 times/week</option>
                                        <option value="1.725">Very Active: intense exercise 6-7 times/week</option>
                                        <option value="1.9">Extra Active: very intense exercise daily, or physical job</option>
                                    </select>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td width="80">Your Goal</td>
                            <td width="500">
                                <label for="goal" >
                                    <select name="goal" id="goal" required>
                                        <option value="m">Maintain Weight</option>
                                        <option value="l">Mild weight loss of 0.5 lb per week</option>
                                        <option value="l1">Weight loss of 1 lb per week</option>
                                        <option value="l2">Extreme weight loss of 2 lb per week</option>
                                        <option value="g">Mild weight gain of 0.5 lb per week</option>
                                        <option value="g1">Weight gain of 1 lb per week</option>
                                        <option value="g2">Extreme weight gain of 2 lb per week</option>
                                    </select>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" name="submit" value="Calculate">
                                <input type="button" value="clear">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>


