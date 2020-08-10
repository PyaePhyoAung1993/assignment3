package com.example.assignment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.example.assignment.adapter.QueenAdapter
import com.example.assignment.api.QueenClient
import com.example.assignment.model.QueenItem
import kotlinx.android.synthetic.main.fragment_king.*
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QueenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_queen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPosts()
    }

    fun getPosts() {
        val apiClient = QueenClient()
        val apiCall1 = apiClient.queenApiService.getQueen()
        apiCall1.enqueue(object : Callback<ArrayList<QueenItem>> {
            override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()

            }

            override fun onResponse(
                call: Call<ArrayList<QueenItem>>,
                response: Response<ArrayList<QueenItem>>
            ) {
//                txtResponse.text = response.body().toString()

//                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show()

                recycleView2.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = QueenAdapter(response.body()!!)
                }


            }

        })


    }
}