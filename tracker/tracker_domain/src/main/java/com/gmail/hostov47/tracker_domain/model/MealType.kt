package com.gmail.hostov47.tracker_domain.model

sealed class MealType(val name: String) {
    object Breakfast: MealType(BREAKFAST)
    object Lunch: MealType(LUNCH)
    object Dinner: MealType(DINNER)
    object Snack: MealType(SNACK)

    companion object {
        fun fromString(name: String): MealType {
            return when (name.lowercase()) {
                BREAKFAST -> Breakfast
                LUNCH -> Lunch
                DINNER -> Dinner
                SNACK -> Snack
                else -> Breakfast
            }
        }

        private const val BREAKFAST = "breakfast"
        private const val LUNCH = "lunch"
        private const val DINNER = "dinner"
        private const val SNACK = "snack"
    }
}
