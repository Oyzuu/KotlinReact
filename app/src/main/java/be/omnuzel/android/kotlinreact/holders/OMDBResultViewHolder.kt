package be.omnuzel.android.kotlinreact.holders

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import be.omnuzel.android.kotlinreact.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.result_cell.view.*

/**
 * Created by isdc on 22/12/16.
 */
class OMDBResultViewHolder(val cellView: View) : RecyclerView.ViewHolder(cellView) {

    companion object {
        const val DEFAULT_WIDTH = 50
        const val DEFAULT_HEIGHT = 70
    }

    var posterView = cellView.posterView
    var titleLabel = cellView.titleLabel
    var yearLabel = cellView.yearLabel
    var typeLabel = cellView.typeLabel

    fun setPoster(posterUrl: String) {
        if (posterUrl == cellView.context.getString(R.string.not_applicable)) {
            posterView.setBackgroundColor(Color.DKGRAY)
        } else {
            Glide.with(cellView.context).load(posterUrl).into(posterView)
        }

    }

    fun setTitle(title: String) {
        titleLabel.text = title
    }

    fun setYear(year: String) {
        yearLabel.text = year
    }

    fun setType(type: String) {
        typeLabel.text = type
    }

}