package com.example.assignment.api

import com.example.assignment.model.KingItem
import com.example.assignment.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface KingApiInterface {

    @GET("king")
    fun getKing() : Call<ArrayList<KingItem>>



}