package com.example.bucketlist

import androidx.recyclerview.widget.RecyclerView
import com.example.bucketlist.databinding.CountryCardBinding
import com.squareup.picasso.Picasso

class CardViewHolder(
    private val cardCellBinding: CountryCardBinding,
    private val clickListener: LocationClickListener
): RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindBook(book: Book){
//        cardCellBinding.cover.setImageResource(book.cover)
        cardCellBinding.title.text = book.title
        val picasso = Picasso.get()
        picasso.load(book.cover)
            .into(cardCellBinding.cover)

        cardCellBinding.locationCardView.setOnClickListener{
            clickListener.onClick(book)
        }
    }
}