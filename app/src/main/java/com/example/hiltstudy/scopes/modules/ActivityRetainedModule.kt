package com.example.hiltstudy.scopes.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

private var id = 0

@InstallIn(ActivityRetainedComponent::class)
@Module
class ActivityRetainedModule {

    @ActivityRetainedScoped
    @Provides
    @Named("id.activity_retained")
    fun provideId(): Int {
        val tmp = id
        id++
        return tmp
    }
}