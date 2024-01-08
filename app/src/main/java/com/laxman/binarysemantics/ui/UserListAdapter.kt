package com.laxman.binarysemantics.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laxman.binarysemantics.databinding.ItemviewUserlistBinding
import com.laxman.binarysemantics.model.UserData

class UserListAdapter(private val context: Context, private val userList :List<UserData>):RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    inner  class  MyViewHolder (val binding: ItemviewUserlistBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding = ItemviewUserlistBinding.inflate(LayoutInflater.from(context), parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.e("TAG", "onBindViewHolder: ${userList[position].email} ", )
        holder.binding.apply {
            data = userList[position]
        }

    }


}