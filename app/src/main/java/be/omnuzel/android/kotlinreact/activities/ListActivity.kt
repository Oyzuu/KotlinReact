package be.omnuzel.android.kotlinreact.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.widget.LinearLayout
import be.omnuzel.android.kotlinreact.R
import be.omnuzel.android.kotlinreact.adapters.OMDBResultAdapter
import be.omnuzel.android.kotlinreact.rest.OMDBApi
import be.omnuzel.android.kotlinreact.rest.entities.OMDBResult
import be.omnuzel.android.reactivetest.utils.toastThis
import kotlinx.android.synthetic.main.activity_list.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ListActivity : AppCompatActivity() {

    private var mAdapter: OMDBResultAdapter = OMDBResultAdapter()
    private var mCurrentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView.adapter = mAdapter
        searchButton.setOnClickListener { launchSearch() }
    }

    private fun launchSearch() {
        val searchString = searchField.text.toString().trim()

        if (searchString.isEmpty() && searchString.length < 2) {
            toastThis("Incorrect input", withContext = this)
            return
        }

        OMDBApi.getResults(searchField.text.toString().trim(), mCurrentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.results }
                .subscribe {
                    it?.let { setRecyclerViewForResult(it) } ?: toastThis("error", withContext = this)
                }
    }

    private fun setRecyclerViewForResult(results: List<OMDBResult>) {
        mAdapter.setResultsAsDataSet(results)
        mAdapter.notifyDataSetChanged()
    }

}
