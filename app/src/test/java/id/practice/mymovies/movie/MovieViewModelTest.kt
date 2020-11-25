package id.practice.mymovies.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.practice.mymovies.ui.main.pages.movie.MovieViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Rule @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getListData() {
        val listData = viewModel.listData
        assertNotNull(listData)
        assertEquals(10, listData.value?.size)
    }
}