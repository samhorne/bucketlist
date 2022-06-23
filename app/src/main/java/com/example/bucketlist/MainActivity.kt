package com.example.bucketlist

import BucketViewModel
import android.app.usage.NetworkStats
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bucketlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LocationClickListener {
    private lateinit var binding:ActivityMainBinding

    override fun onStart() {
       //TODO: Put logs here to learn what each function does.
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val model: BucketViewModel by viewModels()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainActivity = this
        model.books.observe(this) { books ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(applicationContext, 1)
                adapter = CardAdapter(books, mainActivity)
            }
        }
        super.onCreate(savedInstanceState)

    }

    override fun onClick(book: Book) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(LOC_ID_EXTRA, book.id)
        startActivity(intent)

    }



}