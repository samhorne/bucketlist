package com.example.carddemo

import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.databinding.CardCellBinding
import com.squareup.picasso.Picasso

class CardViewHolder(
    private val cardCellBinding: CardCellBinding
): RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindBook(book: Book){
        cardCellBinding.cover.setImageResource(book.cover)
        val picasso = Picasso.get()
        picasso.load("https://www.commonwealthfund.org/sites/default/files/styles/countries_hero_desktop/public/country_image_Japan.jpg")
            .into(cardCellBinding.cover)
    }
}