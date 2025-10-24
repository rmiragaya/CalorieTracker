package com.rmiragaya.mytracker_presentation.tracker_overview

import androidx.annotation.DrawableRes
import com.rmiragaya.core.util.UiText
import com.rmiragaya.mytracker_data.model.MealType

data class Meal(
    val name: UiText,
    @DrawableRes val drawbleRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
)

val defaultMeals = listOf(
    Meal(
        name = UiText.StringResource(com.rmiragaya.core.R.string.breakfast),
        drawbleRes = com.rmiragaya.core.R.drawable.ic_breakfast,
        mealType = MealType.Breakfast
    ),
    Meal(
        name = UiText.StringResource(com.rmiragaya.core.R.string.lunch),
        drawbleRes = com.rmiragaya.core.R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.StringResource(com.rmiragaya.core.R.string.dinner),
        drawbleRes = com.rmiragaya.core.R.drawable.ic_dinner,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UiText.StringResource(com.rmiragaya.core.R.string.snacks),
        drawbleRes = com.rmiragaya.core.R.drawable.ic_snack,
        mealType = MealType.Snack
    )
)
