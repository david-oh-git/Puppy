package io.davidosemwota.puppy.ui.main

import androidx.lifecycle.ViewModel
import io.davidosemwota.puppy.data.DataSource
import io.davidosemwota.puppy.data.Pup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    dataSource: DataSource = DataSource
) : ViewModel() {

    private val _state = MutableStateFlow(MainViewState())
    val state: StateFlow<MainViewState>
        get() = _state

    init {
        _state.value = MainViewState(dataSource.puppies)
    }
}

data class MainViewState(
    val puppies: List<Pup> = emptyList(),
    val errorMessage: String? = null
)