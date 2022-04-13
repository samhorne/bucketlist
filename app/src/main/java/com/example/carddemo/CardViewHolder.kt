package com.example.carddemo

import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.databinding.CardCellBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding
): RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindBook(book: Book){
        cardCellBinding.cover.setImageResource(book.cover)
        cardCellBinding.title.text = book.title
        cardCellBinding.author.text = book.author
    }
}