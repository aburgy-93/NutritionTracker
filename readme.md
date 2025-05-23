# Food Tracker - Individual Project - Alex Burgy

## Problem Statement

The Nutrition Tracker determines the user's daily macronutrient needs (carbohydrates, protein, and 
fat in grams) based on their fitness goals, whether it's weight loss, muscle gain, or 
maintenance. Users can log the foods they eat throughout the day, and the app provides a 
running total of each macronutrient consumed.

The app displays progress toward daily macronutrient targets, such as:

    0/150g protein
    0/200g carbs
    0/75g fat

As users add meals, the totals update dynamically. For example, after logging a meal with 
50 g protein, 75 g carbs, and 15 g fat, the display updates to:

    50/150g protein
    75/200g carbs
    15/75g fat

To provide visual feedback, the app adjusts the display as users approach their targets. 
Text color transitions from red (far from goal) to green (on target), or a message appears 
indicating how many grams remain. If a user exceeds their daily goal significantly, 
the display reflects that as well.

### Presentation
* App Demo - https://www.youtube.com/watch?v=uaJj2eTW7PU
* Code Demo - https://www.youtube.com/watch?v=_2QT-O_I5a0

### Design
* [User Stories](DesignDocuments/userStoreis.md)
* [ScreenDesign](DesignDocuments/wireframes)
* [Database Design](DesignDocuments/databaseDesign.png)

1) Create meal
2) Food tracker
3) Update meal
4) Delete meal
5) Created food table
6) Search food table from Spoonacular API

### Timelog
* [Timelog Document](timeLog.md)

##### Future Ideas
I could add an activity tracker with in it as well.
Something to record if you worked out that day,
the duration of the workout, intensity level, on a scale of 1–10 how happy were you with the workout, or
a notes section. 

## Project Technologies/Techniques
- Security/Authentication
  - AWS Cognito
- Database
  - MySQL 8.x
- ORM Framework
  - Hibernate 
- Web Services consumed using Java
  - Spoonacular API (https://spoonacular.com/food-api)
  - USDA API (V2)
- CSS 
  - Bootstrap
  - Custom CSS
- Data Validation
  - Bootstrap Validator for the front end
- Logging
  - Log4J2
- Hosting
  - AWS (V2)
- Tech I'd like to explore as part of this work
  - 
- Unit Testing
  - JUnit tests
- IDE: IntelliJ IDEA


## ScreenShots

### Login Screen
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/LoginScreen.png">

### Homepage
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/HomePage.png">

### User Food Table
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/UserFoodTable.png">

### Spoonacular API Search
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/SpoonacularSearch.png">

### Food Tracker
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/FoodTracker.png">

### Add Food
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/AddFoodForm.png">

### Edit Food
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/EditFoodForm.png">

### Edit Meal
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/EditMealForm.png">

### Logout Screen
<img src="https://github.com/aburgy-93/NutritionTracker/blob/main/screenshots/app/LogoutScreen.png">