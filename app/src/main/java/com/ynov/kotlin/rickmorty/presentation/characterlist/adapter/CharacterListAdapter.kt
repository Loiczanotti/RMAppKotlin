package com.ynov.kotlin.rickmorty.presentation.characterlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.characterlist.adapter.viewholder.CharacterViewHolder
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper.CharacterViewDataWrapper

class CharacterListAdapter(val context: Context): RecyclerView.Adapter<CharacterViewHolder>() {

    private val items: MutableList<CharacterViewDataWrapper> = mutableListOf()
    var onItemClickListener: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_character, parent, false))
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position], onItemClickListener)
    }

    fun setItems(characterList: List<CharacterViewDataWrapper>) {
        items.clear()
        items.addAll(characterList)
        notifyDataSetChanged()
    }

}