package com.example.carddemo

var suggestionList = mutableListOf<Suggestion>()

class Suggestion(
    var type: String,
    var text: String,
    var img_url: String,
    var link_url: String,
    var id: Int? = suggestionList.size
)

