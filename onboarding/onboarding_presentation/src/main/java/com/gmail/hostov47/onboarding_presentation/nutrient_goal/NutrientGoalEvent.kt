/**
 * Created by Ilia Shelkovenko on 29.01.2023.
 */

package com.gmail.hostov47.onboarding_presentation.nutrient_goal

sealed class NutrientGoalEvent {
    data class onCarbRatioEnter(val ratio: String) : NutrientGoalEvent()
    data class onProteinRatioEnter(val ratio: String) : NutrientGoalEvent()
    data class onFatRatioEnter(val ratio: String) : NutrientGoalEvent()
    object onNextClick : NutrientGoalEvent()
}