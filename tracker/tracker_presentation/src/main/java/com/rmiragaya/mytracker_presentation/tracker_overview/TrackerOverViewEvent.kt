package com.rmiragaya.mytracker_presentation.tracker_overview

import com.rmiragaya.mytracker_data.model.TrackedFood

sealed class TrackerOverViewEvent {
    object OnNextDayClick: TrackerOverViewEvent()
    object OnPreviousDayClick: TrackerOverViewEvent()
    data class OnToggleMEalClick(val meal: Meal): TrackerOverViewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverViewEvent()
    data class OnAddFoodClick(val meal: Meal): TrackerOverViewEvent()
}