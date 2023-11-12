package hera.flixnow.made.submission2.di

import dagger.Component
import hera.flixnow.made.submission2.ui.components.MainActivity
import hera.flixnow.made.submission2.ui.components.detail.DetailActivity
import hera.flixnow.made.submission2.ui.components.movie.MovieFragment
import hera.flixnow.made.submission2.ui.components.tv.TvFragment
import hera.flixnow.made.core.di.CoreComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: DetailActivity)
    fun inject(fragment: MovieFragment)
    fun inject(fragment: TvFragment)
}