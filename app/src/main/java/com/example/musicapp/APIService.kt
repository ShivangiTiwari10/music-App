package com.example.musicapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val BASE_URL ="https://shazam.p.rapidapi.com/"



interface APIService {


    @GET("shazam-events/list")
    suspend fun getTodos(): List<songList>

    companion object {
        private var apiService: APIService? = null

        fun getInstance(apiKey: String): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }

}