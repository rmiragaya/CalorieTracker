package com.rmiragaya.mytracker_data.use_case

import com.rmiragaya.mytracker_data.model.TrackableFood
import com.rmiragaya.mytracker_data.model.TrackedFood
import com.rmiragaya.mytracker_data.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        repository.deleteTrackedFood(trackedFood)
    }
}