package com.example.bucketlist

data class Suggestion(
    var type: String,
    var text: String,
    var img_url: String,
    var link_url: String,
    var id: Int?
)

data class RepoResult(
    val id: Int,
    val name: String,
    val suggestions: List<Suggestion>?,
    )
