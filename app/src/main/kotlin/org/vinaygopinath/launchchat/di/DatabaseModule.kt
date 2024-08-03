package org.vinaygopinath.launchchat.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.vinaygopinath.launchchat.AppDatabase
import org.vinaygopinath.launchchat.daos.ActionDao
import org.vinaygopinath.launchchat.daos.ActivityDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.buildDatabase(context)
    }

    @Provides
    @Singleton
    fun provideActivityDao(database: AppDatabase): ActivityDao {
        return database.activityDao()
    }

    @Provides
    @Singleton
    fun provideActionDao(database: AppDatabase): ActionDao {
        return database.actionDao()
    }
}