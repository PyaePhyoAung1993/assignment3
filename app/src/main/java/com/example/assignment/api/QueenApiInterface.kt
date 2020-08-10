package com.example.assignment.api

import com.example.assignment.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface QueenApiInterface {

    @GET("queen")
    fun getQueen() : Call<ArrayList<QueenItem>>
}