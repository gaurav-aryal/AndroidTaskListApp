package com.example.tasklist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*


class TasksAdapter(val list: ArrayList<Task>):RecyclerView.Adapter<TaskViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTodo = list[position]
        holder.checkBox.setChecked(false)
        holder.text.text = currentTodo.text
    }

}

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
        private var view: View = itemView
//        private var photo: Photo? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }
    val checkBox:CheckBox = itemView.iv_icon
    val text: TextView = itemView.tv_icon
    }