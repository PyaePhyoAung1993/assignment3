package com.example.assignment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.example.assignment.adapter.KingAdapter
import com.example.assignment.adapter.QueenAdapter
import com.example.assignment.api.KingClient
import com.example.assignment.model.KingItem
import kotlinx.android.synthetic.main.fragment_king.*
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class KingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_king, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPosts()
    }

    fun getPosts() {
        val apiClient = KingClient()
        val apiCall = apiClient.kingApiService.getKing()
        apiCall.enqueue(object : Callback<ArrayList<KingItem>> {
            override fun onFailure(call: Call<ArrayList<KingItem>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()

            }

            override fun onResponse(
                call: Call<ArrayList<KingItem>>,
                response: Response<ArrayList<KingItem>>
            ) {
//                txtResponse.text = response.body().toString()

//                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show()

                recycleView1.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = KingAdapter(response.body()!!)
                }


            }

        })


    }
}