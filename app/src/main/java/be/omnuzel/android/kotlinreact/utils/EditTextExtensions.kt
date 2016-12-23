package be.omnuzel.android.kotlinreact.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by isdc on 23/12/16.
 */

inline fun EditText.onTextChanged(crossinline body: EditText.() -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            body()
        }
    })
}
