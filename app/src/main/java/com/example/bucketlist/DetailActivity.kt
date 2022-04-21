package com.example.bucketlist

//import com.example.carddemo.Request
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bucketlist.databinding.ActivityDetailBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

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
        //Implement Coroutine Here
        callLocationApi()

    }

    open fun callLocationApi(){

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/api/v1/bucketlist/1")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    println(response.toString())
                    var created_list = Gson().fromJson(response.body()?.string(), RepoResult::class.java)
                    suggestionList.postValue(created_list.suggestions)
                }
            }
        })
//        val repoListJsonStr = URL(URL).readText()
    }

}