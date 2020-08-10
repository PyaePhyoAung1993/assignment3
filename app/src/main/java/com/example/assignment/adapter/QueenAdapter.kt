package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.QueenItem
import kotlinx.android.synthetic.main.list_queen.view.*


class QueenAdapter(var queenList: ArrayList<QueenItem>) :
        RecyclerView.Adapter<QueenAdapter.QueenViewHolder>() {

        class QueenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            fun bind(queen: QueenItem) {
                itemView.t7.text = queen.`class`
                itemView.t8.text = queen.id
                itemView.t9.text = queen.img_url
                itemView.t10.text = queen.name
                itemView.t11.text = queen.vote_count.toString()
                itemView.t12.text = queen.vote_time_status.toString()


            }
        }

        //choose layout
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(
                R.layout.list_queen,
                parent, false
            )
            return QueenViewHolder(view)
        }

        //count
        override fun getItemCount(): Int {
            return queenList.size

        }

        //position
        override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
            holder.bind(queenList[position])
        }
    }
