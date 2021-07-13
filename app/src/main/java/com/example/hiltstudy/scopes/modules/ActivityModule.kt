package com.example.hiltstudy.scopes.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

private var id = 0

@InstallIn(ActivityComponent::class)
@Module
class ActivityModule {

    @ActivityScoped
    @Provides
    @Named("id.activity")
    fun provideId(): Int {
        val tmp = id
        id++
        return tmp
    }
}