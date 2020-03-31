package com.artemissoftware.bundleapp.todolist

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.artemissoftware.bundleapp.R
import io.realm.Realm

class FinishToDoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_to_do)

        title = "Complete to DO"

        val toDoItemId = intent.getStringExtra("todoItem")

        val realm = Realm.getDefaultInstance()

        val toDoItem = realm.where(ToDoItem::class.java).equalTo("id", toDoItemId).findFirst()


        (findViewById(R.id.toDoNameTextView) as TextView).text = toDoItem?.name

        if(toDoItem?.important == true){
            (findViewById(R.id.toDoNameTextView) as TextView).setTypeface(Typeface.DEFAULT_BOLD)
        }

        (findViewById(R.id.completeButton) as Button).setOnClickListener{

            realm.beginTransaction()
            toDoItem?.deleteFromRealm()
            realm.commitTransaction()
            finish()
        };

    }

}
