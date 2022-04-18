package com.example.carddemo

import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.databinding.SuggestionCardBinding
import com.squareup.picasso.Picasso

class SuggestionViewHolder(
    private val cardCellBinding: SuggestionCardBinding
): RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindSuggestion(suggestion: Suggestion){
//        cardCellBinding.cover.setImageResource(book.cover)
        cardCellBinding.title.text = book.title
        val picasso = Picasso.get()
        picasso.load(book.cover)
            .into(cardCellBinding.cover)
    }
}