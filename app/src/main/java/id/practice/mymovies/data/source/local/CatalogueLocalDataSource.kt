package id.practice.mymovies.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.practice.mymovies.data.entity.Catalogue
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.data.source.CatalogueDataSource
import javax.inject.Inject

class CatalogueLocalDataSource @Inject constructor() : CatalogueDataSource {

    private val _getAllMovies = MutableLiveData<List<Movie>>().apply {
        value = Catalogue.loadData().movie
    }
    override fun getAllMovies(): LiveData<List<Movie>> = _getAllMovies

    private val _getAllTVs = MutableLiveData<List<TV>>().apply {
        value = Catalogue.loadData().tv
    }
    override fun getAllTVs(): LiveData<List<TV>> = _getAllTVs
}