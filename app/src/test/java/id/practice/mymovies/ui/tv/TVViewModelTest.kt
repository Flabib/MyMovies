package id.practice.mymovies.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.practice.mymovies.data.entity.Catalogue
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.data.source.CatalogueRepository
import id.practice.mymovies.ui.main.pages.tv.TVViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock private lateinit var viewModel: TVViewModel
    @Mock private lateinit var catalogueRepository: CatalogueRepository
    @Mock private lateinit var observer: Observer<List<TV>>

    @Before
    fun setUp() {
        viewModel = TVViewModel(catalogueRepository)
    }

    @Test
    fun getListData() {
        val dummyTVs = Catalogue.loadData().tv
        val tvs = MutableLiveData<List<TV>>()
        tvs.value = dummyTVs

        `when`(catalogueRepository.getAllTVs()).thenReturn(tvs)

        assertNotNull(catalogueRepository.getAllTVs())
        val listData = viewModel.getAllTVs()
        assertEquals(10, listData.value?.size)

        viewModel.getAllTVs().observeForever(observer)
        verify(observer).onChanged(dummyTVs)
    }
}