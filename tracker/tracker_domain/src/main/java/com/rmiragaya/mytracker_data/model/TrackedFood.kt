package com.rmiragaya.mytracker_data.model

import com.rmiragaya.core.domain.model.GoalType
import java.time.LocalDate

data class TrackedFood(
    val name: String,
    val imageUrl: String?,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val mealType: MealType,
    val amount: Int,
    val date: LocalDate,
    val calories: Int,
    val id: Int? = null
)
