package com.example.carddemo

var suggestionList = mutableListOf<Suggestion>()

data class Suggestion(
    var type: String,
    var title: String,
    var img_url: String,
    var link_url: String,
    var id: Int? = suggestionList.size
)

