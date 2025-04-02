document.addEventListener("DOMContentLoaded", function () {
    const serving = document.getElementById("servings");
    const calories = document.getElementById("calories");
    const protein = document.getElementById("protein");
    const carbs = document.getElementById("carbs");
    const fat = document.getElementById("fat");

    // Get the JSP values from the hidden inputs
    let originalServingSize = parseFloat(document.getElementById("foodServingSize").value) || 1;
    let originalCalories = parseFloat(document.getElementById("foodCalories").value) || 0;
    let originalProtein = parseFloat(document.getElementById("foodProtein").value) || 0;
    let originalCarbs = parseFloat(document.getElementById("foodCarbs").value) || 0;
    let originalFat = parseFloat(document.getElementById("foodFat").value) || 0;

    serving.addEventListener("input", function () {
        let newServingSize = parseFloat(serving.value) || 1;

        if (!isNaN(newServingSize) && originalServingSize > 0) {
            calories.value = ((newServingSize / originalServingSize) * originalCalories).toFixed(2);
            protein.value = ((newServingSize / originalServingSize) * originalProtein).toFixed(2);
            carbs.value = ((newServingSize / originalServingSize) * originalCarbs).toFixed(2);
            fat.value = ((newServingSize / originalServingSize) * originalFat).toFixed(2);
        }
    });
});
