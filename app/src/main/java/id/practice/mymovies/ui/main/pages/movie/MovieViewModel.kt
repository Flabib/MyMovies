package id.practice.mymovies.ui.main.pages.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.source.CatalogueRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val movieRepository: CatalogueRepository) : ViewModel() {
    fun getAllMovies(): LiveData<List<Movie>> = movieRepository.getAllMovies()
}