/**
 * Created by Ilia Shelkovenko on 27.01.2023.
 */

package com.gmail.hostov47.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.gmail.hostov47.core.domain.preferences.Preferences
import com.gmail.hostov47.core.domain.use_case.FilterOutDigits
import com.gmail.hostov47.core.navigation.Route
import com.gmail.hostov47.core.util.UiEvent
import com.gmail.hostov47.core.util.UiText
import com.gmail.hostov47.core.R


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {
    var age by mutableStateOf("20")

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEnter(age: String){
        if(age.length <= 3){
            this.age = filterOutDigits(age)
        }
    }

    fun onNextClick(){
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(UiText.StringResource(R.string.error_age_cant_be_empty))
                )
                return@launch
            }
            preferences.saveAge(ageNumber)
            _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
        }
    }
}