package com.rmiragaya.onboarding_presentation.nutrient_goal

sealed class NutrientGoalEvent {
    data class OnCarbRatioEvent(val ratio: String) : NutrientGoalEvent()
    data class OnProteinRatioEvent(val ratio: String) : NutrientGoalEvent()
    data class OnFatRatioEvent(val ratio: String) : NutrientGoalEvent()
    object OnNextClick : NutrientGoalEvent()
}