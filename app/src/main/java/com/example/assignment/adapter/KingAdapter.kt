package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.KingItem
import kotlinx.android.synthetic.main.list_king.view.*



class KingAdapter(var kingList: ArrayList<KingItem>) :
        RecyclerView.Adapter<KingAdapter.KingViewHolder>() {

        class KingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            fun bind(king: KingItem) {
                itemView.t1.text = king.`class`
                itemView.t2.text = king.id
                itemView.t3.text = king.img_url
                itemView.t4.text = king.name
                itemView.t5.text = king.vote_count.toString()
                itemView.t6.text = king.vote_time_status.toString()


            }
        }

        //choose layout
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(
                R.layout.list_king,
                parent, false
            )
            return KingViewHolder(view)
        }

        //count
        override fun getItemCount(): Int {
            return kingList.size

        }

        //position
        override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
            holder.bind(kingList[position])
        }
    }
