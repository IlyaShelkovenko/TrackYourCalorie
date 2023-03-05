/**
 * Created by Ilia Shelkovenko on 05.03.2023.
 */

package com.gmail.hostov47.tracker_domain.use_case

import com.gmail.hostov47.tracker_domain.model.MealType
import com.gmail.hostov47.tracker_domain.model.TrackableFood
import com.gmail.hostov47.tracker_domain.model.TrackedFood
import com.gmail.hostov47.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
                protein = ((food.proteinsPer100g / 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt(),
                imageUrl = food.imageUrl,
                amount = amount,
                mealType = mealType,
                date = date
            )
        )
    }
}