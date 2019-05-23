package com.ynov.kotlin.rickmorty.presentation.characterdetail.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.base.fragment.BaseFragment
import com.ynov.kotlin.rickmorty.presentation.characterdetail.viewmodel.CharacterDetailViewModel
import com.ynov.kotlin.rickmorty.presentation.extensions.observeSafe
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper.CharacterViewDataWrapper
import kotlinx.android.synthetic.main.fragment_character_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailFragment : BaseFragment() {

    val args by navArgs<CharacterDetailFragmentArgs>()
    private val characterDetailViewModel : CharacterDetailViewModel by viewModel()

    override fun layoutId(): Int = R.layout.fragment_character_detail


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(args.id != 0) {
            characterDetailViewModel.retrieveCharacter(args.id)
        }

        characterDetailViewModel.character.observeSafe(this) {
            updateView(it)
        }
    }

    private fun updateView(character: CharacterViewDataWrapper) {
        Picasso.get().load(character.getImage()).into(rm_character_detail_image_view)
    }
}