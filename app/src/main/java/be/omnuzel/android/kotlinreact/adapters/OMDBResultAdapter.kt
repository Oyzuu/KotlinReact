package be.omnuzel.android.kotlinreact.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import be.omnuzel.android.kotlinreact.R
import be.omnuzel.android.kotlinreact.holders.OMDBResultViewHolder
import be.omnuzel.android.kotlinreact.rest.entities.OMDBResult
import java.util.*

/**
 * Created by isdc on 22/12/16.
 */
class OMDBResultAdapter : RecyclerView.Adapter<OMDBResultViewHolder>() {

    private var mDataSet: List<OMDBResult> = ArrayList()

    override fun getItemCount() = mDataSet.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OMDBResultViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.result_cell, parent, false)

        return OMDBResultViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OMDBResultViewHolder?, position: Int) {
        val result = mDataSet[position]
        holder?.setPoster(result.posterUrl ?: "")
        holder?.setTitle(result.title ?: "")
        holder?.setYear(result.year ?: "")
        holder?.setType(result.type ?: "")
    }

    public fun setResultsAsDataSet(results: List<OMDBResult>) {
        mDataSet = results
    }
}