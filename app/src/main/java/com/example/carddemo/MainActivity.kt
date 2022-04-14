package com.example.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateBooks()

        val mainActivity = this
        binding.recyclerView.apply{
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(bookList)
        }
    }

    private fun populateBooks()
    {
        val book1 = Book(
            R.drawable.abtm,
            "Victoria Devine",
            "AGELESS BODY, TIMELESS MIND",
        )
        bookList.add(book1)

        val book2 = Book(
            R.drawable.tmom,
            "Amanda Lohrey",
            "THE MIRACLE OF MINDFULNESS",
        )
        bookList.add(book2)

        val book3 = Book(
            R.drawable.trlt,
            "M. Scott Peck",
            "THE ROAD LESS TRAVELLED",
        )
        bookList.add(book3)

        val book4 = Book(
            R.drawable.iewu,
            "Colleen Hoover",
            "IT ENDS WITH US",
        )
        bookList.add(book4)

        val book5 = Book(
            R.drawable.ips,
            "Ross Coulthart",
            "IN PLAIN SIGHT",
        )
        bookList.add(book5)

        val book6 = Book(
            R.drawable.ttmc,
            "Richard Osman",
            "THE THURSDAY MURDER CLUB",
        )
        bookList.add(book6)

        val book7 = Book(
            R.drawable.wyam,
            "Michael Robotham",
            "WHEN YOU ARE MINE",
        )
        bookList.add(book7)


        bookList.add(book1)
        bookList.add(book2)
        bookList.add(book3)
        bookList.add(book4)
        bookList.add(book5)
        bookList.add(book6)
        bookList.add(book7)
    }
}