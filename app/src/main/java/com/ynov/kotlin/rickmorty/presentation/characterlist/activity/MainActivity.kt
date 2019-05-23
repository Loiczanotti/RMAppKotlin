package com.ynov.kotlin.rickmorty.presentation.characterlist.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.characterlist.fragment.CharacterListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            findNavController(R.id.rm_activity_main_fragment)
                .setGraph(R.navigation.nav_graph, intent.extras)
        }
    }
}
