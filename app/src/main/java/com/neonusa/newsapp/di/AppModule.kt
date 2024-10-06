package com.neonusa.newsapp.di

import android.app.Application
import com.neonusa.newsapp.data.manager.LocalUserManagerImpl
import com.neonusa.newsapp.domain.LocalUserManager
import com.neonusa.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.neonusa.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.neonusa.newsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}