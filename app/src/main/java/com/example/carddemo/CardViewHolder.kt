package com.example.carddemo

import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.databinding.CardCellBinding
import com.squareup.picasso.Picasso

class CardViewHolder(
    private val cardCellBinding: CardCellBinding
): RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindBook(book: Book){
//        cardCellBinding.cover.setImageResource(book.cover)
        cardCellBinding.title.text = book.title
        val picasso = Picasso.get()
        picasso.load(book.cover)
            .into(cardCellBinding.cover)
    }
}