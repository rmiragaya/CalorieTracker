package com.rmiragaya.mytracker_data.mapper

import com.rmiragaya.mytracker_data.local.entity.TrackedFoodEntity
import com.rmiragaya.mytracker_data.model.MealType
import com.rmiragaya.mytracker_data.model.TrackedFood
import java.time.LocalDate

fun TrackedFoodEntity.toTrackedFood() : TrackedFood {
    return TrackedFood (
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        mealType = MealType.fromString(type),
        imageUrl = imageUrl,
        amount = amount,
        calories = calories,
        date = LocalDate.of(year, month, dayOfMonth),
        id = id
    )
}

fun TrackedFood.toTrackedFoodEntity() : TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        type = mealType.name,
        imageUrl = imageUrl,
        amount = amount,
        calories = calories,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        id = id
    )
}