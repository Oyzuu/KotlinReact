package be.omnuzel.android.kotlinreact.rest.services

import be.omnuzel.android.kotlinreact.rest.entities.OMDBResultList
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

/**
 * Created by isdc on 22/12/16.
 */
interface OMDBService {

    @GET("/")
    fun getResults(@Query("s") title: String, @Query("page") page: Int): Single<OMDBResultList>

}
