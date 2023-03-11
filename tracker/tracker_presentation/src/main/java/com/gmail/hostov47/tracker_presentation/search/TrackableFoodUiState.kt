/**
 * Created by Ilia Shelkovenko on 11.03.2023.
 */

package com.gmail.hostov47.tracker_presentation.search

import com.gmail.hostov47.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)