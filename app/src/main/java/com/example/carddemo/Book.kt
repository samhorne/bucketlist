package com.example.carddemo

var bookList = mutableListOf<Book>()

class Book(
    var cover: Int,
    var title: String,
    var description: String,
    var id: Int? = bookList.size
)

