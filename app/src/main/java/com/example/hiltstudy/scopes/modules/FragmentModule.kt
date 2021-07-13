package com.example.hiltstudy.scopes.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Named

private var id = 0

@InstallIn(FragmentComponent::class)
@Module
class FragmentModule {

    @FragmentScoped
    @Provides
    @Named("id.fragment")
    fun provideId(): Int {
        val tmp = id
        id++
        return tmp
    }
}