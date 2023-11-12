package hera.flixnow.made.core.di

import dagger.Binds
import dagger.Module
import hera.flixnow.made.core.data.source.TMDBRepository
import hera.flixnow.made.core.domain.repository.IMovieTvRepository

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

  @Suppress("unused")
  @Binds
  abstract fun provideRepository(tmdbRepository: TMDBRepository): IMovieTvRepository
}