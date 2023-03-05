/**
 * Created by Ilia Shelkovenko on 05.03.2023.
 */

package com.gmail.hostov47.tracker_domain.use_case

import com.gmail.hostov47.tracker_domain.model.TrackedFood
import com.gmail.hostov47.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {
    operator fun invoke(
        date: LocalDate
    ): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}