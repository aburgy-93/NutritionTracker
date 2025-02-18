## Problem Statement

Nutrition Tracker determines the user's daily macronutrient needs (carbohydrates, protein, and 
fat in grams) based on their fitness goals, whether it's weight loss, muscle gain, or 
maintenance. Users can log the foods they eat throughout the day, and the app provides a 
running total of each macronutrient consumed.

The app displays progress toward daily macronutrient targets, such as:

    0/150g protein
    0/200g carbs
    0/75g fat

As users add meals, the totals update dynamically. For example, after logging a meal with 
50g protein, 75g carbs, and 15g fat, the display updates to:

    50/150g protein
    75/200g carbs
    15/75g fat

To provide visual feedback, the app adjusts the display as users approach their targets. 
Text color transitions from red (far from goal) to green (on target), or a message appears 
indicating how many grams remain. If a user exceeds their daily goal significantly, 
the display reflects that as well.

##### Future Ideas
I could also add an activity tracker with in it as well. Something to record if you worked out that day,
the duration of the workout, intensity level, on a scale of 1-10 how happy were you with the workout, or
a notes section. 

## Project Technologies/Techniques
- Security/Authentication
  - AWS Cognito
- Database
  - MySQL 8.x
- ORM Framework
  - Hibernate 
- Web Services consumed using Java
  - TBD 
- CSS 
  - Bootstrap
- Data Validation
  - Bootstrap Validator for front end
- Logging
  - Log4J2
- Hosting
  - AWS
- Tech I'd like to explore as part of this work
  - TBD
  - Food database API
- Unit Testing
  - JUnit tests
- IDE: IntelliJ IDEA


## Design 
Screens: 

1) Create meal
2) View meals
3) Update meal
4) Delete Meal