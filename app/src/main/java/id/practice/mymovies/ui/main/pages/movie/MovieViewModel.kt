package id.practice.mymovies.ui.main.pages.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.practice.mymovies.data.Catalogue
import id.practice.mymovies.data.Movie

class MovieViewModel : ViewModel() {

    private val _listData = MutableLiveData<List<Movie>>().apply {
        value = Catalogue.loadData().movie
    }
    val listData: LiveData<List<Movie>> = _listData
}