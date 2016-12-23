package be.omnuzel.android.kotlinreact.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.widget.LinearLayout
import be.omnuzel.android.kotlinreact.R
import be.omnuzel.android.kotlinreact.adapters.OMDBResultAdapter
import be.omnuzel.android.kotlinreact.rest.OMDBApi
import be.omnuzel.android.kotlinreact.rest.entities.OMDBResultList
import be.omnuzel.android.kotlinreact.utils.onTextChanged
import be.omnuzel.android.kotlinreact.utils.subscribeAndSetResults
import kotlinx.android.synthetic.main.activity_list.*
import rx.Single
import rx.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class ListActivity : AppCompatActivity() {

    private var mAdapter: OMDBResultAdapter = OMDBResultAdapter()
    private var mCurrentPage = 1
    private val mSubject: PublishSubject<Single<OMDBResultList>> = PublishSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView.adapter = mAdapter
        searchField.onTextChanged { launchSearch() }

        // API call Single<> is wrapped in a PublishSubject to debounce
        mSubject.debounce(400, TimeUnit.MILLISECONDS).subscribe {
            it.subscribeAndSetResults(mAdapter)
        }
    }

    //region Methods
    private fun launchSearch() {
        val searchString = searchField.text.toString().trim()

        if (searchString.length < 2) {
            mAdapter.clearDataset()
            return
        }

        mSubject.onNext(OMDBApi.getResults(searchString, mCurrentPage))
    }
    //endregion

}
