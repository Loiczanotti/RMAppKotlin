package com.ynov.kotlin.rickmorty.presentation.characterdetail.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.base.fragment.BaseFragment
import com.ynov.kotlin.rickmorty.presentation.characterdetail.viewmodel.CharacterDetailViewModel
import com.ynov.kotlin.rickmorty.presentation.extensions.convertDateToFr
import com.ynov.kotlin.rickmorty.presentation.extensions.observeSafe
import com.ynov.kotlin.rickmorty.presentation.viewdatawrapper.CharacterViewDataWrapper
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
        Picasso.get().load(character.getImage()).into(rm_fragment_character_detail_image_view)
        rm_fragment_character_detail_name.text = character.getName()
        rm_fragment_character_detail_status.text = character.getStatus()
        rm_fragment_character_detail_species.text = character.getSpecies()
        rm_fragment_character_detail_gender.text = character.getGender()
        rm_fragment_character_detail_origin.text = context?.getString(R.string.fragment_detail_origin_text, character.getOriginName())
        rm_fragment_character_detail_location.text = context?.getString(R.string.fragment_detail_location_text, character.getLocationName())
        rm_fragment_character_detail_created.text = context?.getString(R.string.fragment_detail_date_text, convertDateToFr(character.getCreated()))
    }
}