package com.artemissoftware.bundleapp.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter (private val list: List<ToDoItem>) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TodoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int = list.size

}