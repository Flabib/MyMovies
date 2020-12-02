package id.practice.mymovies.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.practice.mymovies.data.entity.Catalogue
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.data.source.CatalogueDataSource
import id.practice.mymovies.data.source.remote.response.MovieResponse
import id.practice.mymovies.data.source.remote.response.TVResponse
import id.practice.mymovies.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CatalogueRemoteDataSource @Inject constructor(private val catalogueServices: CatalogueServices) : CatalogueDataSource {
    override fun getAllMovies(): LiveData<List<Movie>> {
        val allMovies = MutableLiveData<List<Movie>>()

        EspressoIdlingResource.increment()

        catalogueServices.movies.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                try {
                    allMovies.postValue(response.body()?.results)

                    EspressoIdlingResource.decrement()
                } catch (e: Exception) {
                    allMovies.postValue(Catalogue.loadData().movie)

                    Log.d("API_RESULT", e.message.toString())
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("API_RESULT", t.message.toString())
            }
        })

        return allMovies
    }

    override fun getAllTVs(): LiveData<List<TV>> {
        val allTVs = MutableLiveData<List<TV>>()

        EspressoIdlingResource.increment()

        catalogueServices.tVs.enqueue(object : Callback<TVResponse> {
            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                try {
                    allTVs.postValue(response.body()?.results)

                    EspressoIdlingResource.decrement()
                } catch (e: Exception) {
                    allTVs.postValue(Catalogue.loadData().tv)

                    Log.d("API_RESULT", e.message.toString())
                }
            }

            override fun onFailure(call: Call<TVResponse>, t: Throwable) {
                Log.d("API_RESULT", t.message.toString())
            }
        })

        return allTVs
    }
}
