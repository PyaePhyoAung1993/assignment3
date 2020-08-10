package com.example.assignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KingClient{




    private val KING_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"


    private var retrofit: Retrofit? = null

    init {
//        fun getRetrofitClient() : Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(KING_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
//            return retrofit
//        }
    }
    val kingApiService = retrofit!!.create(KingApiInterface::class.java)
}