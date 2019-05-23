package com.ynov.kotlin.rickmorty.presentation.component

import android.content.Context
import android.view.View

interface SnackBarComponent {
    fun showSnackBarError(view: View, message: String, context: Context)
}