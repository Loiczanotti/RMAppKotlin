package com.ynov.kotlin.rickmorty.presentation.episodeslist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.episodeslist.adapter.viewholder.EpisodeViewholder
import com.ynov.kotlin.rickmorty.presentation.episodeslist.viewdatawrapper.EpisodeViewDataWrapper

class EpisodeListAdapter (private val context: Context): RecyclerView.Adapter<EpisodeViewholder>() {

    private val items: MutableList<EpisodeViewDataWrapper> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewholder {
        return EpisodeViewholder(
            LayoutInflater.from(context).inflate(
                R.layout.item_episode,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EpisodeViewholder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(characterList: List<EpisodeViewDataWrapper>) {
        items.clear()
        items.addAll(characterList)
        notifyDataSetChanged()
    }

}