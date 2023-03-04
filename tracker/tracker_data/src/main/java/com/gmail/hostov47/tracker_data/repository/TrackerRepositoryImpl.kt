/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */

package com.gmail.hostov47.tracker_data.repository

import com.gmail.hostov47.tracker_data.local.TrackerDao
import com.gmail.hostov47.tracker_data.mapper.toTrackableFood
import com.gmail.hostov47.tracker_data.mapper.toTrackedFood
import com.gmail.hostov47.tracker_data.mapper.toTrackedFoodEntity
import com.gmail.hostov47.tracker_data.remote.OpenFoodApi
import com.gmail.hostov47.tracker_domain.model.TrackableFood
import com.gmail.hostov47.tracker_domain.model.TrackedFood
import com.gmail.hostov47.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val api: OpenFoodApi,
) : TrackerRepository {

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDao = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(searchDao.products.mapNotNull { it.toTrackableFood() })
        } catch(e: Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}