package id.practice.mymovies.data.source

import androidx.lifecycle.LiveData
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.entity.TV

interface CatalogueDataSource {
    fun getAllMovies(): LiveData<List<Movie>>?
    fun getAllTVs(): LiveData<List<TV>>?
}