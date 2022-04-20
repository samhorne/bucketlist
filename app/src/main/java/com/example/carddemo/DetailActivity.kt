package com.example.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carddemo.databinding.ActivityDetailBinding
import com.example.carddemo.databinding.ActivityMainBinding
//import com.example.carddemo.Request
import com.google.gson.Gson
import net.bytebuddy.implementation.MethodCall.run
import org.json.JSONArray
import java.net.URL

//data class RepoResult(val items: List<Suggestion>)


open class DetailActivity : AppCompatActivity() {

    var suggestionList = MutableLiveData<List<Suggestion>>()

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
        val adapter = DetailAdapter()
        suggestionList.observe(this) {
            adapter.suggestions = it
        }
        binding.detailRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            this.adapter = adapter
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
//        val suggestion1 = Suggestion(
//            "Image",
//            "Tokyo",
//            "https://upload.wikimedia.org/wikipedia/commons/f/f9/Marina_Bay_Sands_in_the_evening_-_20101120.jpg",
//            "https://www.google.com/search?q=tokyo",
//        0
//        )
//        suggestionList.add(suggestion1)

//        doAsync {
//            Request(url).run()
//            uiThread { longToast("Request performed") }
//        }
        var payload = callLocationApi()
        var created_list = SuggestionRepository.createObjectsFromApiCall(payload)
        suggestionList.value = created_list.suggestions

    }

    open fun callLocationApi(): String{
        var rqst = MyRequest()
        var resp = rqst.run()
//        val repoListJsonStr = URL(URL).readText()
        return ""
    }

}