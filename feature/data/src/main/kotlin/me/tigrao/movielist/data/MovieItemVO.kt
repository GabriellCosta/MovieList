package me.tigrao.movielist.data

import android.os.Parcel
import android.os.Parcelable

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class MovieItemVO(
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val genre: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeString(posterPath)
        parcel.writeString(genre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieItemVO> {
        override fun createFromParcel(parcel: Parcel): MovieItemVO {
            return MovieItemVO(parcel)
        }

        override fun newArray(size: Int): Array<MovieItemVO?> {
            return arrayOfNulls(size)
        }
    }
}
