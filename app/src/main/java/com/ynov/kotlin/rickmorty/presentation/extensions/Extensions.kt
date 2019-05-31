package com.ynov.kotlin.rickmorty.presentation.extensions

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.text.SimpleDateFormat
import java.util.*

fun <T> LiveData<T>.observeSafe(owner: LifecycleOwner, observer: (T) -> Unit) {
    this.observe(owner, Observer<T> { t ->
        if (t != null) {
            observer(t)
        }
    })
}

// TODO c'est pas une extension ça, c'est juste une fonction
//  il aurait fallu plutôt donner fun String.convertDateToFr(): String
fun convertDateToFr(dateStr: String): String {
    val inputFormat = "yyyy-MM-dd'T'HH:mm:ss"
    val format = "yyyy-MM-dd"
    val parser = SimpleDateFormat(inputFormat, Locale.getDefault())
    val formatter = SimpleDateFormat(format, Locale.getDefault())

    return formatter.format(parser.parse(dateStr))
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}