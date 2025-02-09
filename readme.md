## Problem Statement

After a decade in the health & fitness industry I understand the importance of keeping track of what
you are eating if you are trying to reach certain fitness goals. Whether that be weight loss,
muscle growth, or maintaining your current weight/physique. I propose developing an app to help
figure out what someone's nutritional needs (carbs, pro, and fat in grams) are based on their
goals. Once given their daily nutritional needs then they can enter the foods they eat throughout
the day and have a running total for the day for each macronutrient.

An idea for the display:
0/150g protein
0/200g carbs
0/75g fat

When a person adds a food/meal the app will add the amount of each macronutrient for a running
total. So if a person has a meal with 50g protein, 75g carbs, and 15g fat it will update to:

50/150g protein
75/200g carbs
15/75g fat

As the user gets closer to their goal for the day the display could update either with a piece of
text saying "only x amount of grams of protein left" or the color of the text could change. So the
further away from your goal it is in red text and the closer you are to the goal the text color changes
(red -> orange -> green). The same logic could also be applied if a person goes over their daily
goal by too much as well.

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