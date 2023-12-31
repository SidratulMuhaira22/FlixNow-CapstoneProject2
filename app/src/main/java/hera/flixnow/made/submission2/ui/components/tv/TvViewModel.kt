package hera.flixnow.made.submission2.ui.components.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import hera.flixnow.made.core.domain.usecase.MovieTvUseCase
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TvViewModel @Inject constructor(private val useCase: MovieTvUseCase?) : ViewModel() {

  val tvShows = useCase?.getTvShows()?.asLiveData()

  val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)
  val search = queryChannel.asFlow()
    .debounce(1000)
    .distinctUntilChanged()
    .filter {
      it.trim().isNotEmpty()
    }
    .mapLatest {
      useCase?.searchTvShows(it)
    }
    .asLiveData()
}