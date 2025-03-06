<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<html>
<head>
    <style>
        /* General Styling */
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 700px !important;
            margin: 40px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 15px;
        }

        p {
            text-align: center;
            color: #555;
        }

        .cal-instructions {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 75%;
            padding: 10px;
            margin-bottom: 20px;
            background-color: #007BFF;
        }

        .cal-instructions p {
            color: white;
            margin: 0px;
        }

        .cal-instructions img {
            margin-right: 8px;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            table-layout: fixed;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
            vertical-align: middle;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        /* Table Cell Width */
        td {
            width: 50%;
        }

        /* Input and Select Styling */
        input, select {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        /* Flexbox for consistent spacing in height and gender rows */
        div {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        span {
            margin-left: 5px;
        }

        /* Radio Button Styling */
        .radio-group {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        label {
            display: inline-flex;
            align-items: center;
            gap: 5px;
            margin-right: 15px;
        }

        /* Button Styling */
        .submit-btn, .clear-btn {
            display: block;
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }

        .submit-btn {
            background: #007BFF;
            color: white;
        }

        .submit-btn:hover {
            background: #0056b3;
        }

        .clear-btn {
            background: #888;
            color: white;
            margin-top: 10px;
        }

        .clear-btn:hover {
            background: #666;
        }

        /* General Input Styling for Consistency */
        input[type="radio"] {
            margin-right: 5px;
        }

        /* Consistent Margin and Padding Reset */
        html, body {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            height: 100%;
        }

        .container {
            display: flex;
            flex-direction: column;
            width: 100%;
            max-width: 1100px;
            margin: 0 auto;
            padding-top: 20px;
        }

        /* Hover Effect for Table Rows */
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<c:import url="navBar.jsp" />

<div class="container">
    <h2>Macro Calculator</h2>
    <p>This calculator helps determine daily macronutrient and calorie needs.</p>

    <div class="cal-instructions">
        <img width="20" height="20" src="images/down-arrow.svg" alt="drop down arrow to change input units">
        <p>Modify values and click "Calculate" to proceed.</p>
    </div>

    <form action="macro-results" method="GET">

        <!-- Age and Gender -->
        <table>
            <tbody>
            <tr>
                <td>Age</td>
                <td>
                    <div style="display: flex; align-items: center; gap: 10px;">
                        <input type="number" name="age" value="25" required>
                        <small>Ages 18-80</small>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <div class="radio-group">
                        <label>
                            <input type="radio" name="gender" value="m" checked> Male
                        </label>
                        <label>
                            <input type="radio" name="gender" value="f"> Female
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Height and Weight -->
        <table>
            <tbody>
            <tr>
                <td>Height</td>
                <td>
                    <div style="display: flex; align-items: center; gap: 10px;">
                        <input type="number" name="heightFeet" value="5" required>
                        <span>ft</span>
                        <input type="number" name="heightInches" value="10" required>
                        <span>in</span>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Weight</td>
                <td>
                    <input type="number" name="weight" value="165" required> lbs
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Activity Level -->
        <table>
            <tbody>
            <tr>
                <td>Activity Level</td>
                <td>
                    <select name="activity" required>
                        <option value="1">Basal Metabolic Rate</option>
                        <option value="1.2">Sedentary: Little to no exercise</option>
                        <option value="1.375">Light: Exercise 1-3 days/week</option>
                        <option value="1.465">Moderate: Exercise 4-5 days/week</option>
                        <option value="1.55">Active: Daily exercise or intense exercise 3-4 times/week</option>
                        <option value="1.725">Very Active: Intense exercise 6-7 times/week</option>
                        <option value="1.9">Extra Active: Very intense exercise daily or physical job</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Goal Selection -->
        <table>
            <tbody>
            <tr>
                <td>Your Goal</td>
                <td>
                    <select name="goal" required>
                        <option value="m">Maintain Weight</option>
                        <option value="l">Mild weight loss (0.5 lb/week)</option>
                        <option value="l1">Weight loss (1 lb/week)</option>
                        <option value="l2">Extreme weight loss (2 lb/week)</option>
                        <option value="g">Mild weight gain (0.5 lb/week)</option>
                        <option value="g1">Weight gain (1 lb/week)</option>
                        <option value="g2">Extreme weight gain (2 lb/week)</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Submit and Clear Buttons -->
        <button type="submit" class="submit-btn">Calculate</button>
        <button type="reset" class="clear-btn">Clear</button>

    </form>
</div>
</body>
</html>
