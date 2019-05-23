package com.ynov.kotlin.rickmorty.presentation.characterdetail.fragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.base.fragment.BaseFragment
import com.ynov.kotlin.rickmorty.presentation.characterdetail.viewmodel.CharacterDetailViewModel
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper.CharacterViewDataWrapper
import com.ynov.kotlin.rickmorty.presentation.component.SnackBarComponent
import com.ynov.kotlin.rickmorty.presentation.extensions.convertDateToFr
import com.ynov.kotlin.rickmorty.presentation.extensions.observeSafe
import kotlinx.android.synthetic.main.fragment_character_detail.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailFragment : BaseFragment() {

    private val args by navArgs<CharacterDetailFragmentArgs>()
    private val characterDetailViewModel: CharacterDetailViewModel by viewModel()
    private val snackBarComponent: SnackBarComponent by inject()

    override fun layoutId(): Int = R.layout.fragment_character_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        super.onViewCreated(view, savedInstanceState)
        if (args.id != 0) {
            characterDetailViewModel.retrieveCharacter(args.id)
        }

        characterDetailViewModel.character.observeSafe(this) {
            updateView(it)
        }

        characterDetailViewModel.errorLiveData.observeSafe(this) {
            it.message?.let { message ->
                snackBarComponent.showSnackBarError(view, message, context!!)
            }

        }
    }

    private fun updateView(character: CharacterViewDataWrapper) {
        (activity as AppCompatActivity).supportActionBar?.title = character.getName()
        Picasso.get().load(character.getImage()).into(rm_fragment_character_detail_image_view)
        rm_fragment_character_detail_name.text = character.getName()
        rm_fragment_character_detail_status.text = character.getStatus()
        rm_fragment_character_detail_species.text = character.getSpecies()
        rm_fragment_character_detail_gender.text = character.getGender()
        rm_fragment_character_detail_origin.text =
            context?.getString(R.string.fragment_detail_origin_text, character.getOriginName())
        rm_fragment_character_detail_location.text =
            context?.getString(R.string.fragment_detail_location_text, character.getLocationName())
        rm_fragment_character_detail_created.text =
            context?.getString(R.string.fragment_detail_date_text, convertDateToFr(character.getCreated()))
    }
}