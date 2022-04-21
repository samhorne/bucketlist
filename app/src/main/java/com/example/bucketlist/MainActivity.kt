package com.example.bucketlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bucketlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LocationClickListener {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateBooks()

        val mainActivity = this
        binding.recyclerView.apply{
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(bookList, mainActivity)
        }
    }

    override fun onClick(book: Book) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(LOC_ID_EXTRA, book.id)
        startActivity(intent)

    }

    private fun populateBooks()
    {
        val book1 = Book(
            "https://www.commonwealthfund.org/sites/default/files/styles/countries_hero_desktop/public/country_image_Japan.jpg",
            "Japan",
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
            "https://uceap.universityofcalifornia.edu/sites/default/files/marketing-images/program-page-images/shanghai-summer-glance.jpg",
            "Shanghai",
            "THE ROAD LESS TRAVELLED",
        )
        bookList.add(book3)

        val book4 = Book(
            "https://www.planetware.com/wpimages/2019/12/israel-in-pictures-beautiful-places-to-photograph-the-western-wall.jpg",
            "Israel",
            "IT ENDS WITH US",
        )
        bookList.add(book4)

        val book5 = Book(
            "https://dynaimage.cdn.cnn.com/cnn/q_auto,w_1770,c_fill,g_auto,h_996,ar_16:9/http%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F170706113411-spain.jpg",
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