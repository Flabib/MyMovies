package id.practice.mymovies.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.practice.mymovies.ui.main.pages.tv.TVViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TVViewModelTest {

    private lateinit var viewModel: TVViewModel

    @Rule @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = TVViewModel()
    }

    @Test
    fun getListData() {
        val listData = viewModel.listData
        assertNotNull(listData)
        assertEquals(10, listData.value?.size)
    }
}