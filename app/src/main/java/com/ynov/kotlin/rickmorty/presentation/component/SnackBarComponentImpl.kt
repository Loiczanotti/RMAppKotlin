package com.ynov.kotlin.rickmorty.presentation.component

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class SnackBarComponentImpl: SnackBarComponent {

    override fun showSnackBarError(view: View, message: String, context: Context) {
        // TODO vous auriez pu utiliser un apply pour setBackgroundColor() et un also pour show()
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
        snackbar.show()
    }
}