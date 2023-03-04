/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */

package com.gmail.hostov47.tracker_domain.model

data class TrackableFood (
    val name: String,
    val imageUrl: String?,
    val caloriesPer100g: Int,
    val carbsPer100g: Int,
    val proteinsPer100g: Int,
    val fatPer100g: Int,
)