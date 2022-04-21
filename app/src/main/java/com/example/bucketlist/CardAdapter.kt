package com.example.bucketlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bucketlist.databinding.CountryCardBinding

class CardAdapter(
    private val books: List<Book>,
    private val clickListener: LocationClickListener)
     : RecyclerView.Adapter<CardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CountryCardBinding.inflate(from, parent, false)
        return CardViewHolder(binding, clickListener )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindBook(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }

}