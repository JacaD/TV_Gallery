package com.example.tv_app.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.tv_app.R

class RecyclerViewAdapter(val context: Context, var entries: ArrayList<Int>) : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return entries.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindEntry(entries[position], context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val entryImage = itemView.findViewById<ImageView>(R.id.galleryItem)

        fun bindEntry(entry: Int, context: Context){
            entryImage.setImageResource(entry)
        }
    }
}