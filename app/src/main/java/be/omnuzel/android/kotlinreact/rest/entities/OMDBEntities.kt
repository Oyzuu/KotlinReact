package be.omnuzel.android.kotlinreact.rest.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by isdc on 22/12/16.
 */

data class OMDBResultList(@SerializedName("Search") val results: List<OMDBResult>)

data class OMDBResult(
        @SerializedName("Title") val title: String?,
        @SerializedName("Year") val year: String?,
        @SerializedName("Type") val type: String?,
        @SerializedName("Poster") val posterUrl: String?
)