package com.example.setu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.setu.databinding.LayoutCovidBinding

class PostAdapter(var post:ArrayList<Resp2>): RecyclerView.Adapter<PostAdapter.vHolder>() {

    inner class vHolder(val binding: LayoutCovidBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
        val binding = LayoutCovidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return vHolder(binding)
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
holder.binding.States.text=post.get(position).state
        holder.binding.Confirmed.text=post.get(position).confirmed
        holder.binding.Recovered.text=post.get(position).recovered
        holder.binding.Death.text=post.get(position).dead
    }

    override fun getItemCount(): Int {
return post.size
    }
}