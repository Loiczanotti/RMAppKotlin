package com.ynov.kotlin.rickmorty.presentation.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    // TODO là on peut ajouter un @CallSuper pour forcer à appeler super quand on override la fonction,
    //  ça évite d'oublier et de tout casser
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

}