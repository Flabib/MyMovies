package id.practice.mymovies.data.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TV(
        @SerializedName("title", alternate = ["name"])
        val title: String? = "",
        @SerializedName("release_date", alternate = ["first_air_date"])
        val releaseDate: String? = "",
        @SerializedName("description", alternate = ["overview"])
        val description: String? = "",
        @SerializedName("original_language")
        val originalLanguage: String? = "",
        @SerializedName("poster", alternate = ["poster_path"])
        val poster: String? = "",
        @SerializedName("backdrop", alternate = ["backdrop_path"])
        val backdrop: String? = "",
        @SerializedName("vote_average")
        val voteAverage: String? = ""
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(title)
                parcel.writeString(releaseDate)
                parcel.writeString(description)
                parcel.writeString(originalLanguage)
                parcel.writeString(poster)
                parcel.writeString(backdrop)
                parcel.writeString(voteAverage)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<TV> {
                override fun createFromParcel(parcel: Parcel): TV {
                        return TV(parcel)
                }

                override fun newArray(size: Int): Array<TV?> {
                        return arrayOfNulls(size)
                }
        }
}