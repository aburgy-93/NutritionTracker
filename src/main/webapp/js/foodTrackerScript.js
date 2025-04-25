document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".day").forEach(function (dayDiv) {
        let dailyTotalProtein = 0;
        let dailyTotalCarbs = 0;
        let dailyTotalFat = 0;
        let dailyTotalCalories = 0;

        dayDiv.querySelectorAll('.meal_facts').forEach(function (row) {
            let proteinEl = row.querySelector('.meal-protein');
            let carbsEl = row.querySelector('.meal-carbs');
            let fatEl = row.querySelector('.meal-fat');
            let caloriesEl = row.querySelector('.meal-calories');

            if(proteinEl && carbsEl && fatEl && caloriesEl) {
                let protein = parseFloat(proteinEl.textContent) || 0;
                let carbs = parseFloat(carbsEl.textContent) || 0;
                let fat = parseFloat(fatEl.textContent) || 0;
                let calories = parseFloat(caloriesEl.textContent) || 0;

                dailyTotalProtein += protein;
                dailyTotalCarbs += carbs;
                dailyTotalFat += fat;
                dailyTotalCalories += calories;
            }
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