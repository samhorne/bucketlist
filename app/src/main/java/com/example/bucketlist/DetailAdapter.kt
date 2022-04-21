package com.example.bucketlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bucketlist.databinding.ImageCardBinding

class DetailAdapter(): RecyclerView.Adapter<SuggestionViewHolder>(){

    var suggestions: List<Suggestion> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ImageCardBinding.inflate(from, parent, false)
        return SuggestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bindSuggestion(suggestions[position])
    }

    override fun getItemCount(): Int {
        return suggestions.size
    }

}