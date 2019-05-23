package com.ynov.kotlin.rickmorty.presentation.characterlist.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.base.fragment.BaseFragment
import com.ynov.kotlin.rickmorty.presentation.characterlist.adapter.CharacterListAdapter
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewmodel.CharacterListViewModel
import com.ynov.kotlin.rickmorty.presentation.extensions.observeSafe
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper.CharacterViewDataWrapper
import com.ynov.kotlin.rickmorty.presentation.component.SnackBarComponent
import com.ynov.kotlin.rickmorty.presentation.extensions.hide
import kotlinx.android.synthetic.main.fragment_character_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : BaseFragment() {

    private val characterListViewModel: CharacterListViewModel by viewModel()
    private val characterListAdapter: CharacterListAdapter by inject()
    private val snackBarComponent: SnackBarComponent by inject()

    override fun layoutId(): Int = R.layout.fragment_character_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.fragment_character_list_title_toolbar)
        setUpRecyclerView()
        characterListViewModel.characterList.observeSafe(this) {
            rm_fragment_character_list_progress.hide()
            updateView(it)
        }

        characterListViewModel.errorLiveData.observeSafe(this) {
            rm_fragment_character_list_progress.hide()
            rm_character_list_swipe.isRefreshing = false
            it.message?.let { message ->
                snackBarComponent.showSnackBarError(view, message, context!!)
            }

        }
    }

    private fun updateView(listCharacter: List<CharacterViewDataWrapper>) {
        rm_character_list_swipe.isRefreshing = false
        characterListAdapter.setItems(listCharacter)

    }

    private fun setUpRecyclerView() {
        val onItemClickListener: (Int) -> Unit = {
            val direction = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailActivity(it)
            findNavController().navigate(direction)
        }
        rm_character_list_swipe.setOnRefreshListener {
            characterListViewModel.retrieveAllCharacter()
        }
        rm_fragment_character_list_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            characterListAdapter.onItemClickListener = onItemClickListener
            adapter = characterListAdapter
        }
    }

}
