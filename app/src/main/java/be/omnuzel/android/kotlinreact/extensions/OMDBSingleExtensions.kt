package be.omnuzel.android.kotlinreact.extensions

import be.omnuzel.android.kotlinreact.adapters.OMDBResultAdapter
import be.omnuzel.android.kotlinreact.rest.entities.OMDBResultList
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by isdc on 23/12/16.
 */

inline fun Single<OMDBResultList>.subscribeAndSetResults(onAdapter: OMDBResultAdapter) {
    subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
            .subscribe {
                it?.let { onAdapter.setResultsAsDataSet(it) }
            }
}
