package hera.flixnow.made.favorites.di

import dagger.Component
import hera.flixnow.made.submission2.di.AppModule
import hera.flixnow.made.core.di.CoreComponent
import hera.flixnow.made.favorites.ui.FavoriteFragment
import hera.flixnow.made.favorites.ui.FavoriteMovieFragment
import hera.flixnow.made.favorites.ui.FavoriteTvFragment

@FavoriteAppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, FavoriteViewModelModule::class]
)
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)
    fun inject(fragment: FavoriteMovieFragment)
    fun inject(fragment: FavoriteTvFragment)
}