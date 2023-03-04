/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */

package com.gmail.hostov47.tracker_data.local

import androidx.room.*
import com.gmail.hostov47.tracker_data.local.entity.TrackedFoodEntity
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
            FROM trackedfoodentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
    )
    fun getFoodForDate(day: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>
}