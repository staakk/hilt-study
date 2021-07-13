package com.example.hiltstudy.assistedinjection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * This [ViewModel] has [arg] param provided by [AssistedInjectViewModelFactory].
 */
class AssistedInjectViewModel @AssistedInject constructor(
    @Assisted val arg: String
) : ViewModel() {

    companion object {
        fun provideFactory(
            assistedFactory: AssistedInjectViewModelFactory,
            arg: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(arg) as T
            }
        }
    }

}

@AssistedFactory
interface AssistedInjectViewModelFactory {
    fun create(arg: String): AssistedInjectViewModel
}