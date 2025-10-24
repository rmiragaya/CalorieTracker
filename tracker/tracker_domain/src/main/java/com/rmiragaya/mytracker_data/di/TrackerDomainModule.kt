package com.rmiragaya.mytracker_data.di

import com.rmiragaya.core.domain.preferences.Preferences
import com.rmiragaya.mytracker_data.repository.TrackerRepository
import com.rmiragaya.mytracker_data.use_case.CalculateMealNutrients
import com.rmiragaya.mytracker_data.use_case.DeleteTrackedFood
import com.rmiragaya.mytracker_data.use_case.GetFoodsForDate
import com.rmiragaya.mytracker_data.use_case.SearchFood
import com.rmiragaya.mytracker_data.use_case.TrackFood
import com.rmiragaya.mytracker_data.use_case.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}