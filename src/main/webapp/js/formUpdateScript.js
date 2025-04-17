document.addEventListener("DOMContentLoaded", function (){
    // Get form elements by their id
   const serving = document.getElementById("servings");
   const calories = document.getElementById("calories");
   const protein = document.getElementById("protein");
   const carbs = document.getElementById("carbs");
   const fat = document.getElementById("fat");

    // Get all inputs and their values with a data attribute
    const nutritionInputs = document.querySelectorAll("input[data-nutrition]");

    // Create an object to hold the key value pairs of the form element and its value (ex: servings: 1)
    let nutritionMap ={};

    // For each input, take its data-nutrition value and set its input.value to a float or 0.
    // Add the key value pair to the nutritionMap object.
    nutritionInputs.forEach(input => {
        nutritionMap[input.dataset.nutrition] = parseFloat(input.value) || 0;
    });

    // Get the original serving size to calculate the nutritional values based on the new serving size.
    let originalServingSize = nutritionMap["serving"] || 1;

    // When the serving amount is updated, the changes below are reflected in the form.
    serving.addEventListener("input", function () {
        let newServingSize = parseFloat(serving.value) || 1;

        if(!isNaN(newServingSize) && originalServingSize > 0) {
            calories.value = ((newServingSize / originalServingSize) * nutritionMap["calories"]).toFixed(2);
            protein.value = ((newServingSize / originalServingSize) * nutritionMap["protein"]).toFixed(2);
            carbs.value = ((newServingSize / originalServingSize) * nutritionMap["carbs"]).toFixed(2);
            fat.value = ((newServingSize / originalServingSize) * nutritionMap["fat"]).toFixed(2);
        }
    })
});