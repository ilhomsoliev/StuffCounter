package com.ilhomsoliev.local.di

import android.app.Application
import androidx.room.Room
import com.ilhomsoliev.local.data.local.StuffDatabase
import com.ilhomsoliev.local.data.repository.StuffRepositoryImpl
import com.ilhomsoliev.local.domain.repository.StuffRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    fun provideStuffDatabase(app: Application): StuffDatabase {
        return Room.databaseBuilder(
            app,
            StuffDatabase::class.java,
            StuffDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideStuffRepository(db: StuffDatabase): StuffRepository {
        return StuffRepositoryImpl(db.stuffDao)
    }
}