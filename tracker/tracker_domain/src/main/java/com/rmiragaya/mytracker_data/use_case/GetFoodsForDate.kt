package com.rmiragaya.mytracker_data.use_case

import com.rmiragaya.mytracker_data.model.TrackableFood
import com.rmiragaya.mytracker_data.model.TrackedFood
import com.rmiragaya.mytracker_data.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        date: LocalDate
    ): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}