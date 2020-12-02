package id.practice.mymovies.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import id.practice.mymovies.data.entity.Catalogue
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.data.source.CatalogueRepository
import id.practice.mymovies.data.source.local.CatalogueLocalDataSource
import id.practice.mymovies.data.source.remote.CatalogueRemoteDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CatalogueRepositoryTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val catalogueRemoteDataSource = Mockito.mock(CatalogueRemoteDataSource::class.java)
    private val catalogueLocalDataSource = Mockito.mock(CatalogueLocalDataSource::class.java)
    private val movieRepository = CatalogueRepository(catalogueRemoteDataSource, catalogueLocalDataSource)
    private val catalogueResponse = Catalogue.loadData()

    @Test
    fun getAllMovies() {
        val dummyMovies = catalogueResponse.movie
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovies

        `when`(catalogueRemoteDataSource.getAllMovies()).thenReturn(movies)

        assertNotNull(catalogueRemoteDataSource.getAllMovies())
        val listData = movieRepository.getAllMovies()
        assertEquals(10, listData.value?.size)
        assertEquals(catalogueResponse.movie.size.toLong(), listData.value?.size?.toLong())
    }

    @Test
    fun getAllTVs() {
        val dummyTVs = catalogueResponse.tv
        val tvs = MutableLiveData<List<TV>>()
        tvs.value = dummyTVs

        `when`(catalogueRemoteDataSource.getAllTVs()).thenReturn(tvs)

        assertNotNull(catalogueRemoteDataSource.getAllTVs())
        val listData = movieRepository.getAllTVs()
        assertEquals(10, listData.value?.size)
        assertEquals(catalogueResponse.tv.size.toLong(), listData.value?.size?.toLong())
    }
}