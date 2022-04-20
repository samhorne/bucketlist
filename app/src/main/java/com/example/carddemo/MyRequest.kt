
package com.example.carddemo

import okhttp3.*
import java.io.IOException

class MyRequest {

    private val client = OkHttpClient()

    fun run() {
        val request = Request.Builder()
            .url("http://10.0.2.2/api/v1/bucketlist/1")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    println(response.toString())
                }
            }
        })
    }
}
