package hera.flixnow.made.submission2.di

import dagger.Binds
import dagger.Module
import hera.flixnow.made.core.domain.usecase.MovieTvInteractor
import hera.flixnow.made.core.domain.usecase.MovieTvUseCase

@Module
abstract class AppModule {

    @Suppress("unused")
    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieTvInteractor): MovieTvUseCase
}