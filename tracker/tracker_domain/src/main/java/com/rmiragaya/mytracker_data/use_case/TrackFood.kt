package com.rmiragaya.mytracker_data.use_case

import com.rmiragaya.mytracker_data.model.MealType
import com.rmiragaya.mytracker_data.model.TrackableFood
import com.rmiragaya.mytracker_data.model.TrackedFood
import com.rmiragaya.mytracker_data.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                imageUrl = food.imageUrl,
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt(),
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
                protein = ((food.proteinPer100g / 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
                mealType = mealType,
                amount = amount,
                date = date
            )
        )
    }
}