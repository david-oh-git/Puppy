package io.davidosemwota.puppy.ui.puppydetail

import androidx.lifecycle.ViewModel
import io.davidosemwota.puppy.data.DataSource
import io.davidosemwota.puppy.data.Pup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PuppyDetailViewModel(
    id: Int,
    dataSource: DataSource = DataSource
) : ViewModel() {

    private val _state = MutableStateFlow(PuppyDetailViewState())
    val state: StateFlow<PuppyDetailViewState>
        get() = _state

    init {
        _state.value = PuppyDetailViewState(
            dataSource.getPuppy(id)
        )
    }
}

data class PuppyDetailViewState(
    val puppy: Pup? = null
)