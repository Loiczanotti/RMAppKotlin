package com.ynov.kotlin.rickmorty.presentation.episodeslist.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.kotlin.rickmorty.presentation.episodeslist.viewdatawrapper.EpisodeViewDataWrapper
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeViewholder(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.rm_episode_list_name
    private val date: TextView = view.rm_episode_list_air_date
    private val episodeText: TextView = view.rm_episode_list_episode

    fun bind(episode: EpisodeViewDataWrapper) {
        name.text = episode.getName()
        date.text = episode.getDate()
        episodeText.text = episode.getEpisode()
    }
}