package be.omnuzel.android.kotlinreact.holders

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import be.omnuzel.android.kotlinreact.R
import be.omnuzel.patternplaceholder.PatternPlaceholder
import be.omnuzel.patternplaceholder.RandomColor
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
            val image = PatternPlaceholder.Builder(cellView.context)
                    .setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT)
                    .setColorGenerationType(RandomColor.ColorType.DARK_GREY)
                    .setPatternType(PatternPlaceholder.PatternType.VERTICAL_LINES)
                    .setTilesPerSide(10)
                    .setText(cellView.context.getString(R.string.not_applicable))
                    .setTextColor(Color.WHITE)
                    .generate()

            posterView.setImageBitmap(image)
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