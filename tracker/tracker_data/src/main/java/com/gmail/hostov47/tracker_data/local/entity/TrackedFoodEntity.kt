/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */

package com.gmail.hostov47.tracker_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrackedFoodEntity(
    val name: String,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val imageUrl: String?,
    val type: String,
    val amount: Int,
    val dayOfMonth: Int,
    val month: Int,
    val year: Int,
    val calories: Int,
    @PrimaryKey val id: Int? = null
)