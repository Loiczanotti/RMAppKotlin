package com.ynov.kotlin.rickmorty.presentation.characterlist.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.presentation.viewdatawrapper.CharacterViewDataWrapper
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val name = view.rm_character_list_name
    val image= view.rm_character_list_image_view

    fun bind(character: CharacterViewDataWrapper, onItemClickListener: (Int) -> Unit) {
        name.text = character.getName()
        Picasso.get().load(character.getImage()).into(image)
        itemView.setOnClickListener { onItemClickListener(character.getId()) }
    }
}