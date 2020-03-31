package com.artemissoftware.bundleapp.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter (private var list: List<ToDoItem>, private val mListener: (ToDoItem) -> Unit) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TodoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list.get(position))

        holder.itemView.setOnClickListener {
            list.get(position)?.let { it1 -> mListener.invoke(it1) }
        }

    }

    override fun getItemCount(): Int = list.size

}