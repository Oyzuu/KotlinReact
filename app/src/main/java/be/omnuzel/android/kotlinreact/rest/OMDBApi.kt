package be.omnuzel.android.kotlinreact.rest

import be.omnuzel.android.kotlinreact.rest.entities.OMDBResultList
import be.omnuzel.android.kotlinreact.rest.services.OMDBService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by isdc on 22/12/16.
 */
object OMDBApi {

    const val DEFAULT_PAGE_NUMBER = 1

    private val service: OMDBService

    init {
        val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())
        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(OMDBService::class.java)
    }

    fun getResults(forTitle: String): Observable<OMDBResultList> =
            service.getResults(forTitle, DEFAULT_PAGE_NUMBER)

    fun getResults(forTitle: String, onPage: Int): Observable<OMDBResultList> =
            service.getResults(forTitle, onPage)
}