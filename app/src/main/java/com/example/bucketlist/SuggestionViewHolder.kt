package com.example.bucketlist

import androidx.recyclerview.widget.RecyclerView
import com.example.bucketlist.databinding.ImageCardBinding
import com.squareup.picasso.Picasso

class SuggestionViewHolder(
    private val suggestionCellBinding: ImageCardBinding
): RecyclerView.ViewHolder(suggestionCellBinding.root) {
    fun bindSuggestion(suggestion: Suggestion){
//        suggestionCellBinding.cover.setImageResource(suggestion.img_url)
        suggestionCellBinding.suggestiontextView.text = "HELLO"

        //Picasso Way
        val picasso = Picasso.get()
        picasso.load(suggestion.img_url)
            .into(suggestionCellBinding.cover)

        suggestionCellBinding.suggestiontextView.text = suggestion.text

//        //Glide way
//        Glide
//            .with(suggestionCellBinding.cover)
//            .load(suggestion.img_url)
//            .into(suggestionCellBinding.cover)

    }
}