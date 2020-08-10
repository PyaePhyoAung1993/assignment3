package com.example.assignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QueenClient{

    private val QUEEN_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"


    private var retrofit: Retrofit? = null

    init {
//        fun getRetrofitClient() : Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(QUEEN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
//            return retrofit
//        }
    }
    val queenApiService = retrofit!!.create(QueenApiInterface::class.java)
}