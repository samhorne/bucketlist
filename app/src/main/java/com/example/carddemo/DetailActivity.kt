package com.example.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carddemo.databinding.ActivityDetailBinding
import com.example.carddemo.databinding.ActivityMainBinding
//import com.example.carddemo.Request
import com.google.gson.Gson
import org.json.JSONArray
import java.net.URL

//data class RepoResult(val items: List<Suggestion>)

open class DetailActivity : AppCompatActivity() {
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

//        doAsync {
//            Request(url).run()
//            uiThread { longToast("Request performed") }
//        }

    }

    open fun createObjectsFromApiCall(): List<Suggestion> {
        var suggestionsToAdd = mutableListOf<Suggestion>()
        var payload = callLocationApi()
        val gson_rtn =  Gson().fromJson(payload, mutableListOf<Suggestion>()::class.java)
        return gson_rtn
    }

    open fun callLocationApi(): String{
        val URL = "http://10.0.2.2/api/v1/bucketlist/1"
        val repoListJsonStr = URL(URL).readText()
        return repoListJsonStr
    }

}