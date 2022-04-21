package com.example.bucketlist

var bookList = mutableListOf<Book>()

val LOC_ID_EXTRA = "bookExtra"

class Book(
    var cover: String,
    var title: String,
    var description: String,
    var id: Int? = bookList.size
)

