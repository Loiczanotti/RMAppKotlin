package com.ynov.kotlin.rickmorty.presentation.view.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.data.model.Character
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    val name = view.rm_character_list_name
    val image= view.rm_character_list_image_view

    fun bind(character: Character) {
        name.text = character.name
        Picasso.get().load(character.image).into(image)
    }
}