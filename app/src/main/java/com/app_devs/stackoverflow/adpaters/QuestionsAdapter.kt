package com.app_devs.stackoverflow.adpaters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app_devs.stackoverflow.databinding.ItemRowBinding
import com.app_devs.stackoverflow.model.Item
import com.bumptech.glide.Glide

class QuestionsAdapter(private val context:Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root)
    var list= listOf<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return MyViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyViewHolder)
        {
            val data=list[position]
            holder.binding.title.text=data.title
            holder.binding.answerCount.text=data.answer_count.toString()
            holder.binding.displayName.text=data.owner.display_name
            //Glide.with(context).load(data.owner.profile_image).into(holder.binding.profile)
            holder.binding.profile.loadImage(data.owner.profile_image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun ImageView.loadImage(url:String)
    {
        Glide.with(this.context).load(url).into(this)
    }

}