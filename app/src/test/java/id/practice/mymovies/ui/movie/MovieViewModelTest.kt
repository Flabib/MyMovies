package id.practice.mymovies.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.practice.mymovies.data.entity.Catalogue
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.source.CatalogueRepository
import id.practice.mymovies.ui.main.pages.movie.MovieViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock private lateinit var viewModel: MovieViewModel
    @Mock private lateinit var catalogueRepository: CatalogueRepository
    @Mock private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getListData() {
        val dummyMovies = Catalogue.loadData().movie
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllMovies()).thenReturn(movies)

        assertNotNull(catalogueRepository.getAllMovies())
        val listData = viewModel.getAllMovies()
        assertEquals(10, listData.value?.size)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}