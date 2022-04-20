package com.example.carddemo

import com.google.gson.Gson

object SuggestionRepository {
    fun createObjectsFromApiCall(payload: String) = Gson().fromJson(payload, RepoResult::class.java)
}