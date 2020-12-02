package id.practice.mymovies.data.source.remote;

import id.practice.mymovies.data.source.remote.response.MovieResponse;
import id.practice.mymovies.data.source.remote.response.TVResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CatalogueServices {
  @GET("discover/movie")
  Call<MovieResponse> getMovies();
  @GET("discover/tv")
  Call<TVResponse> getTVs();
}