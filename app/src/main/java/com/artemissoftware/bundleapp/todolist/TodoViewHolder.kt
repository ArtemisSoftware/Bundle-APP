package com.artemissoftware.bundleapp.todolist

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R

class TodoViewHolder (inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_todo, parent, false)) {

    private var todoDescription: TextView? = null

    init {
        todoDescription = itemView.findViewById(R.id.todoDescription)
    }

    fun bind(todo: ToDoItem) {
        todoDescription?.text = todo.name

        if(todo.important == true){
            todoDescription?.setTypeface(Typeface.DEFAULT_BOLD)
        }
        else{
            todoDescription?.setTypeface(Typeface.DEFAULT)
        }

    }

}