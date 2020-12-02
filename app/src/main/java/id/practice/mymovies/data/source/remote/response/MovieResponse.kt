package id.practice.mymovies.data.source.remote.response

import com.google.gson.annotations.SerializedName
import id.practice.mymovies.data.entity.Movie

class MovieResponse {
    @SerializedName("page")
    var page = 0
    @SerializedName("results")
    var results: ArrayList<Movie>? = null
    @SerializedName("total_results")
    var totalResults = 0
    @SerializedName("total_pages")
    var totalPages = 0
}