package com.example.notes_app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.notes_app.data.datasource.NotesDataSource
import com.example.notes_app.data.datasource.SharedPrefNotesDataSource
import com.example.notes_app.data.repository.NotesRepositoryImpl
import com.example.notes_app.domain.repository.NotesRepository
import com.google.gson.Gson
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
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("notes_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideNotesDataSource(prefs: SharedPreferences): NotesDataSource {
        // Here is where you provide your specific implementation
        return SharedPrefNotesDataSource(prefs,Gson())
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dataSource: NotesDataSource): NotesRepository {
        return NotesRepositoryImpl(dataSource)
    }
}