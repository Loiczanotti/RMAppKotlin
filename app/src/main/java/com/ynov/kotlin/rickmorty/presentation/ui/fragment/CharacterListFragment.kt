package com.ynov.kotlin.rickmorty.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.presentation.ui.adapter.CharacterListAdapter
import com.ynov.kotlin.rickmorty.presentation.view.model.HomeViewModel
import kotlinx.android.synthetic.main.fragment_charactere.*
import org.koin.androidx.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    override fun layoutId(): Int = R.layout.fragment_charactere

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.character.observe(this, Observer<List<Character>> {
            updateView(it)
        })
    }

    private fun updateView(listCharacter: List<Character>) {
        rm_fragment_character_list_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CharacterListAdapter(listCharacter, context)
        }
    }


    companion object {
        fun newInstance(): CharacterListFragment {
            val args: Bundle = Bundle()
            val fragment = CharacterListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
