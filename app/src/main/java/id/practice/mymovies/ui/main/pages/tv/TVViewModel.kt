package id.practice.mymovies.ui.main.pages.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.data.source.CatalogueRepository
import javax.inject.Inject

class TVViewModel @Inject constructor(private val movieRepository: CatalogueRepository): ViewModel() {
    fun getAllTVs(): LiveData<List<TV>> = movieRepository.getAllTVs()
}