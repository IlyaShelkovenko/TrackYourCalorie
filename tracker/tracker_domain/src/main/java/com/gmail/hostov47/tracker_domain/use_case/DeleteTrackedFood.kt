/**
 * Created by Ilia Shelkovenko on 05.03.2023.
 */

package com.gmail.hostov47.tracker_domain.use_case

import com.gmail.hostov47.tracker_domain.model.TrackedFood
import com.gmail.hostov47.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        trackedFood: TrackedFood
    ){
        repository.deleteTrackedFood(trackedFood)
    }
}