package com.example.hiltstudy.assistedinjection.regular

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * This [ViewModel] uses [SavedStateHandle] to get the arguments. [SavedStateHandle] and
 * other dependencies ([additionalParam]) are provided by Hilt.
 */
@HiltViewModel
class RegularViewModel @Inject constructor(
    private val state: SavedStateHandle,
    @Named("param") private val additionalParam: String,
) : ViewModel() {

    init {
        Timber.d(additionalParam)
    }

    val arg by lazy { state["arg"] ?: "" }
}