package com.example.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carddemo.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateBooks()

        val mainActivity = this
        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = CardAdapter(bookList)
        }
    }

    private fun populateBooks()
    {
        val book1 = Book(
            "https://www.commonwealthfund.org/sites/default/files/styles/countries_hero_desktop/public/country_image_Japan.jpg",
            "Tokyo",
            "AGELESS BODY, TIMELESS MIND",
        )
        bookList.add(book1)

        val book2 = Book(
            "https://upload.wikimedia.org/wikipedia/commons/f/f9/Marina_Bay_Sands_in_the_evening_-_20101120.jpg",
            "Singapore",
            "THE MIRACLE OF MINDFULNESS",
        )
        bookList.add(book2)

        val book3 = Book(
            "https://www.thedrinksbusiness.com/content/uploads/2016/09/Shanghai-1024x488.jpg",
            "Shanghai",
            "THE ROAD LESS TRAVELLED",
        )
        bookList.add(book3)

        val book4 = Book(
            "https://wallpaperaccess.com/full/1150751.jpg",
            "Israel",
            "IT ENDS WITH US",
        )
        bookList.add(book4)

        val book5 = Book(
            "https://media.cntraveler.com/photos/5a985924d41cc84048ce6db0/master/w_4348,h_3261,c_limit/Catedral-de-Barcelona-GettyImages-511874340.jpg",
            "Spain",
            "IN PLAIN SIGHT",
        )
        bookList.add(book5)

        val book6 = Book(
            "https://cdn.britannica.com/20/191120-050-B6C0B7E9/village-Hallstatt-Alps-Austria.jpg",
            "Austria",
            "THE THURSDAY MURDER CLUB",
        )
        bookList.add(book6)

        val book7 = Book(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Machu_Picchu%2C_Peru.jpg/1200px-Machu_Picchu%2C_Peru.jpg",
            "Peru",
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