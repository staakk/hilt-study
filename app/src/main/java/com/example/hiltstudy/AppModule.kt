package com.example.hiltstudy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private var id = 0

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Named("param")
    fun provideSomeParam() = "additional param"

    @Singleton
    @Provides
    @Named("id.singleton")
    fun provideId(): Int {
        val tmp = id
        id++
        return tmp
    }
}

