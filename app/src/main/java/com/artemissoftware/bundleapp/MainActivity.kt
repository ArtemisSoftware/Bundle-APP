package com.artemissoftware.bundleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.artemissoftware.bundleapp.gitrepo.GitRepoActivity
import com.artemissoftware.bundleapp.todolist.TodoListActivity
import com.artemissoftware.bundleapp.weather.WeatherActivity
import com.artemissoftware.bundleapp.weather.WeatherForecastActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (findViewById(R.id.weatherButton) as Button).setOnClickListener{weatherButton__OnClickListener(it)};
        (findViewById(R.id.todoButton) as Button).setOnClickListener{todoButton__OnClickListener(it)};
        (findViewById(R.id.gitRepohButton) as Button).setOnClickListener{gitRepohButton__OnClickListener(it)};

    }


    private fun weatherButton__OnClickListener(it: View?) {

        val intent = Intent(getApplicationContext(), WeatherActivity::class.java)
        startActivity(intent)
    }


    private fun todoButton__OnClickListener(it: View?) {

        val intent = Intent(getApplicationContext(), TodoListActivity::class.java)
        startActivity(intent)
    }

    private fun gitRepohButton__OnClickListener(it: View?) {

        val intent = Intent(getApplicationContext(), GitRepoActivity::class.java)
        startActivity(intent)
    }
}
