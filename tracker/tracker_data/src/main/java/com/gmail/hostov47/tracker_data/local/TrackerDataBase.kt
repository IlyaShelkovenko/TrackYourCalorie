/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */

package com.gmail.hostov47.tracker_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gmail.hostov47.tracker_data.local.entity.TrackedFoodEntity

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDataBase : RoomDatabase() {
    abstract val trackerDao: TrackerDao
}