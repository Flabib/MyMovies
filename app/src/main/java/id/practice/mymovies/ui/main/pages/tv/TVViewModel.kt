package id.practice.mymovies.ui.main.pages.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.practice.mymovies.data.Catalogue
import id.practice.mymovies.data.TV

class TVViewModel : ViewModel() {

    private val _listData = MutableLiveData<List<TV>>().apply {
        value = Catalogue.loadData().tv
    }
    val listData: LiveData<List<TV>> = _listData
}