/**
 * Created by Ilia Shelkovenko on 26.01.2023.
 */

package com.gmail.hostov47.core.util

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()
    data class ShowSnackbar(val message: UiText) : UiEvent()
}