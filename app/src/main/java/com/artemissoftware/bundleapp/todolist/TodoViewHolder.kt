package com.artemissoftware.bundleapp.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R

class TodoViewHolder (inflater: LayoutInflater, parent: ViewGroup) :

    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_todo, parent, false)) {

    private var todoDescription: TextView? = null
    private var todoImportant: TextView? = null

    init {
        todoDescription = itemView.findViewById(R.id.todoDescription)
        todoImportant = itemView.findViewById(R.id.todoImportant)
    }

    fun bind(todo: ToDoItem) {
        todoDescription?.text = todo.name
        todoImportant?.text = todo.important.toString()
    }

}