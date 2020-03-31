package com.artemissoftware.bundleapp.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemissoftware.bundleapp.R

class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title = "New Todo"
    }
}
