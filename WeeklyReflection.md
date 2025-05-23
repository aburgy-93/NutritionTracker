# Weekly Reflection

Document how your week in Ent Java went. You may use whatever format suits you, as long as you share how much time you 
worked and provide a general overview of how things went: achievements and struggles.


### Week 2

1/30/2025 - 2.5 hours

Tasks Completed:
 * Chose a project goal
 * Created this repository
 * Wrote the problem statement
 * Started documenting the project plan
 * Began listing technologies and how they fit in this project


### Week 3

2/09/2025 - 3 hours

Tasks Completed:
 * Updated user stories and denoted MVPs
 * Updated readme with possible technologies 
 * Brainstormed screen designs
 * Looked into food nutritionResponse APIs
   * this is giving me some issues as most food APIs are a paid service 
   * may have to instead have each user manually input their food(s)/meal(s) into local database,
   * then they can query that database. 
 * Weekly reflection

I have a pretty good idea of where I want to go with this project. I still need to design some wireframes
of what each page will/might look like and will get them done before the 2/12 due date. 
Need to keep researching if there are any free/easy to use APIs with food/nutritionResponse data. If all else fails
users can create their own local database with food they have entered themselves and can re-use those items
over and over again.

#### Week 4 
2/12/2025

Task completed:
* Created the screens for each webpage
* Created DOAs for Food, User, UserFood classes
* Created test classes for those DOAs

Not too many issues or roadbeds this week.
Mostly getting used to working with hibernate and setting up the DOAs for each of the classes I created. I need to next
work on setting up the JSP and controllers for each webpage. I also need to make sure I figure out how to properly
assign the userId to the added food item. 

#### Week 5
2/23/2025

Task completed:
* Implemented Hibernate 
* Created a Generic Dao file
* Refactored old DAOs to that the entities use the Generic Dao file
* Refactored tests to use the Generic Dao file
* Refactored some items in the test DB. The columns with the total of a nutrient added up now have decimals 
* Worked on implementing calculating totals on the fly.

The biggest task this week that I worked on was getting the Generic Dao file set up and then using it to be able to get 
rid of all the DAOs I had made previously. 
At the same time also making sure the tests for each entity work with the Generic Dao.
Also worked on implementing Hibernate and being able to query the databases without writing SQL. 