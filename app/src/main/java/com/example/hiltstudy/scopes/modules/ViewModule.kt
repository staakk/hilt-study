package com.example.hiltstudy.scopes.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.scopes.ViewScoped
import javax.inject.Named

private var id = 0

@InstallIn(ViewComponent::class)
@Module
class ViewModule {

    @ViewScoped
    @Provides
    @Named("id.view")
    fun provideId(): Int {
        val tmp = id
        id++
        return tmp
    }
}