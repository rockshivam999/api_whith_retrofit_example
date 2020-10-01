package com.example.Restapiexample.InternalLogic

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.Restapiexample.Api.ModelClass
import com.example.Restapiexample.R
import kotlinx.android.synthetic.main.item.view.*

class CustomAdapter(val items:List<ModelClass>,val context:Context) :RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image=itemView.findViewById<ImageView>(R.id.image_item)
        val detail=itemView.findViewById<TextView>(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide.with(holder.image.context).load(https://source.unsplash.com/random)).placeholder(R.drawable.ic_cloud).into(holder.image)
        holder.detail.text=items[position].title
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
