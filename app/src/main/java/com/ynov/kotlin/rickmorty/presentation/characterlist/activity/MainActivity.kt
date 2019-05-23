package com.ynov.kotlin.rickmorty.presentation.characterlist.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ynov.kotlin.rickmorty.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.rm_activity_main_fragment)
        if (savedInstanceState == null) {
            navController.setGraph(R.navigation.nav_graph, intent.extras)
        }
        bottom_navigation.setupWithNavController(navController)
    }




}
