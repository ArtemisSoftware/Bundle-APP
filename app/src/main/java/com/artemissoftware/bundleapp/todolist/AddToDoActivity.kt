package com.artemissoftware.bundleapp.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.artemissoftware.bundleapp.R
import io.realm.Realm

class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title = "New Todo"

        (findViewById(R.id.addButton) as Button).setOnClickListener{addButton__OnClickListener(it)};

    }


    private fun addButton__OnClickListener(it: View?) {

        val todo = ToDoItem()
        todo.name = (findViewById(R.id.toDoEditText) as EditText).text.toString()
        todo.important = (findViewById(R.id.importatCheckBox) as CheckBox).isChecked

        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealm(todo)
        realm.commitTransaction()

        finish()
    }
}
