package com.example.hiltstudy.assistedinjection.serviceconfig

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * This class is provided from assisted factory [MyServiceFactory].
 */
class MyService @AssistedInject constructor(
    // Additional dependencies can be requested and provided by Hilt.
    @Assisted val arg: String
)

@AssistedFactory
interface MyServiceFactory {
    fun create(arg: String): MyService
}