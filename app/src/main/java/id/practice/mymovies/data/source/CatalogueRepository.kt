package id.practice.mymovies.data.source

import androidx.lifecycle.LiveData
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.data.source.local.CatalogueLocalDataSource
import id.practice.mymovies.data.source.remote.CatalogueRemoteDataSource
import javax.inject.Inject

class CatalogueRepository @Inject constructor(
    private val catalogueRemoteDataSource: CatalogueRemoteDataSource,
    private val catalogueLocalDataSource: CatalogueLocalDataSource,
): CatalogueDataSource {
    override fun getAllMovies(): LiveData<List<Movie>> = catalogueRemoteDataSource.getAllMovies()

    override fun getAllTVs(): LiveData<List<TV>> = catalogueRemoteDataSource.getAllTVs()
}