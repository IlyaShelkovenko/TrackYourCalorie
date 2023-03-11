/**
 * Created by Ilia Shelkovenko on 11.03.2023.
 */

package com.gmail.hostov47.tracker_presentation.search

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val trackableFood: List<TrackableFoodUiState> = emptyList()
)