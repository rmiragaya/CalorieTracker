package com.rmiragaya.mytracker_data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rmiragaya.mytracker_data.local.entity.TrackedFoodEntity
import com.rmiragaya.mytracker_data.model.TrackedFood
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    @Delete
    suspend fun deleteTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    @Query(
        """
        SELECT *
        FROM TrackedFoodEntity
        WHERE dayOfMonth = :dayOfMonth AND month = :month AND year = :year
        """
    )
    fun getFoodsForDate(dayOfMonth: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>
}