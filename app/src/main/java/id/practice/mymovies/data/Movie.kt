package id.practice.mymovies.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("description")
    val description: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("poster")
    val poster: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: String,
    @SerializedName("title")
    val title: String
) : Parcelable