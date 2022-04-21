package com.example.bucketlist

import com.google.gson.Gson

object SuggestionRepository {
    fun createObjectsFromApiCall(payload: String) = Gson().fromJson(payload, RepoResult::class.java)
}