/**
 * Created by Ilia Shelkovenko on 29.01.2023.
 */

package com.gmail.hostov47.onboarding_presentation.nutrient_goal

sealed class NutrientGoalEvent {
    data class OnCarbRatioEnter(val ratio: String) : NutrientGoalEvent()
    data class OnProteinRatioEnter(val ratio: String) : NutrientGoalEvent()
    data class OnFatRatioEnter(val ratio: String) : NutrientGoalEvent()
    object OnNextClick : NutrientGoalEvent()
}