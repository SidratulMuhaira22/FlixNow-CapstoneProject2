package hera.flixnow.made.submission2.ui.components.detail

import androidx.lifecycle.*
import hera.flixnow.made.core.domain.model.MovieTv
import hera.flixnow.made.core.domain.usecase.MovieTvUseCase
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: MovieTvUseCase?) : ViewModel() {
    private val _movieTvItem = MutableLiveData<MovieTv>()
    val movieTvItem: LiveData<MovieTv> = _movieTvItem
    var isFavorite: LiveData<Boolean> = Transformations.switchMap(_movieTvItem) { item ->
        useCase?.isFavorite(item)?.asLiveData()
    }

    fun setSelectedItem(item: MovieTv) {
        _movieTvItem.postValue(item)
    }

    fun setToFavorite(saved: Boolean) {
        _movieTvItem.value?.let {
            useCase?.setFavoriteMovieTv(it, saved)
            _movieTvItem.postValue(it)
        }
    }
}