package com.artemissoftware.bundleapp.todolist

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.artemissoftware.bundleapp.R
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener{
            var addIntent = Intent(this, AddToDoActivity::class.java)
            startActivity(addIntent)
        }



    }

}
