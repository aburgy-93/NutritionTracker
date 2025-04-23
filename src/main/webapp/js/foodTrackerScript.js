document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".day").forEach(function (dayDiv) {
        let dailyTotalProtein = 0;
        let dailyTotalCarbs = 0;
        let dailyTotalFat = 0;
        let dailyTotalCalories = 0;

        dayDiv.querySelectorAll('.meal_facts').forEach(function (row) {
            let protein = parseFloat(row.querySelector('.meal-protein').textContent) || 0;
            let carbs = parseFloat(row.querySelector('.meal-carbs').textContent) || 0;
            let fat = parseFloat(row.querySelector('.meal-fat').textContent) || 0;
            let calories = parseFloat(row.querySelector('.meal-calories').textContent) || 0;

            dailyTotalProtein += protein;
            dailyTotalCarbs += carbs;
            dailyTotalFat += fat;
            dailyTotalCalories += calories;
        });

        const proteinSpan = dayDiv.querySelector(".dailyTotalProtein");
        const carbsSpan = dayDiv.querySelector(".dailyTotalCarbs");
        const fatSpan = dayDiv.querySelector(".dailyTotalFat");
        const calSpan = dayDiv.querySelector(".dailyTotalCalories");

        if (proteinSpan) proteinSpan.textContent = dailyTotalProtein;
        if (carbsSpan) carbsSpan.textContent = dailyTotalCarbs;
        if (fatSpan) fatSpan.textContent = dailyTotalFat;
        if (calSpan) calSpan.textContent = dailyTotalCalories;
    });
});