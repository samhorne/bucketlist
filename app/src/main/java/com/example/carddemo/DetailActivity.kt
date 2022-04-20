package com.example.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carddemo.databinding.ActivityDetailBinding
import com.example.carddemo.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import com.example.carddemo.Request
import org.json.JSONArray

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateSuggestions()

        val bookId = intent.getIntExtra(LOC_ID_EXTRA, -1 )
        val book = bookFromId(bookId)
        if (book != null){

        }

        val mainActivity = this
        binding.detailRecyclerView.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = DetailAdapter(suggestionList)
        }
    }

    fun bookFromId(id: Int): Book? {
        for(book in bookList){
            if (book.id == id){
                return book
            }
        }
        return null
    }

    private fun populateSuggestions()
    {
        val suggestion1 = Suggestion(
            "Image",
            "Tokyo",
            "https://upload.wikimedia.org/wikipedia/commons/f/f9/Marina_Bay_Sands_in_the_evening_-_20101120.jpg",
            "https://www.google.com/search?q=tokyo"
        )
        suggestionList.add(suggestion1)

        doAsync {
            Request(url).run()
            uiThread { longToast("Request performed") }
        }

    }

    private fun createObjectsFromApiCall(): MutableList<Suggestion> {
        var suggestionsToAdd = mutableListOf<Suggestion>()

        return suggestionsToAdd
    }

}