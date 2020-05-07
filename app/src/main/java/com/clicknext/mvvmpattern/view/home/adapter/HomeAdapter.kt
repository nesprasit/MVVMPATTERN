package com.clicknext.mvvmpattern.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clicknext.mvvmpattern.R
import com.clicknext.mvvmpattern.service.model.home.GetPhotosResultModel

class HomeAdapter (val data:GetPhotosResultModel): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.home_item,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.onBind(position)
    }


    inner class ViewHolder(internal var item: View):RecyclerView.ViewHolder(item){
        private lateinit var imv:ImageView

        init {
            imv = item.findViewById(R.id.imv_HomeItem)
        }

        fun onBind(position: Int){
            val data = data[position]
            Glide.with(itemView.context)
                .load(data.downloadUrl)
                .into(imv)
        }
    }
}














