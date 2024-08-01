package com.rmiragaya.onboarding_presentation.nutrient_goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmiragaya.core.domain.preferences.Preferences
import com.rmiragaya.core.domain.use_case.FilterOutDigit
import com.rmiragaya.core.navigation.Route
import com.rmiragaya.core.util.UiEvent
import com.rmiragaya.onboarding_domain.use_case.ValidateNutrients
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigit: FilterOutDigit,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {

    var state by mutableStateOf(NutrientGoalState())
        private set

    // Channel to send UI events from ViewModel to the UI layer.
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when (event) {
            is NutrientGoalEvent.OnCarbRatioEvent -> {
                if (event.ratio.length <= 3){
                    state = state.copy(
                        carbsRatio = filterOutDigit(event.ratio)
                    )
                }
            }

            is NutrientGoalEvent.OnProteinRatioEvent -> {
                state = state.copy(
                    proteinRatio = filterOutDigit(event.ratio)
                )
            }

            is NutrientGoalEvent.OnFatRatioEvent -> {
                state = state.copy(
                    fatRatio = filterOutDigit(event.ratio)
                )
            }

            is NutrientGoalEvent.OnNextClick -> {
                val result = validateNutrients(
                    carbsRatioText = state.carbsRatio,
                    proteinRatioText = state.proteinRatio,
                    fatRatioText = state.fatRatio
                )

                when (result) {
                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbRatio(result.carbsRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        preferences.saveFatRatio(result.fatRatio)
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Navigate(Route.TRACKER_OVERVIEW))
                        }
                    }

                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.ShowSnackbar(message = result.message))
                        }
                    }
                }
            }
        }
    }
}