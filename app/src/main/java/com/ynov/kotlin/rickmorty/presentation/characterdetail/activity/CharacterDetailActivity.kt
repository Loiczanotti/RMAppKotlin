package com.ynov.kotlin.rickmorty.presentation.characterdetail.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.ynov.kotlin.rickmorty.R

class CharacterDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        if (savedInstanceState == null) {
            findNavController(R.id.rm_fragment_character_detail)
                .setGraph(R.navigation.character_detail_nav_graph, intent.extras)
        }
    }
}