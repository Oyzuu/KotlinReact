package be.omnuzel.android.reactivetest.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by isdc on 22/12/16.
 */
fun toastThis(message: String, withContext: Context) {
    Toast.makeText(withContext, message, Toast.LENGTH_SHORT).show()
}
