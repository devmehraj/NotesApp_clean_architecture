package com.example.notes_app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.notes_app.domain.repository.NotesRepository
import com.example.notes_app.domain.usecase.AddNoteUseCase
import com.example.notes_app.domain.usecase.GetNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideGetNotesUseCase(repository: NotesRepository): GetNoteUseCase{
        return GetNoteUseCase(repository)
    }
    @Provides
    fun providesAddNoteUseCase(repository: NotesRepository): AddNoteUseCase{
        return AddNoteUseCase(repository)
    }



}