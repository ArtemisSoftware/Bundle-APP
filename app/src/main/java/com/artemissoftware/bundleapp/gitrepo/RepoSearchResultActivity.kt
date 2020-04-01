package com.artemissoftware.bundleapp.gitrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R
import retrofit2.Call
import retrofit2.Response

class RepoSearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_search_result)
/*
        var rcl_forecast = findViewById<RecyclerView>(R.id.rcl_forecast)

        rcl_forecast.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            //adapter = WeatherListAdapter(mNicolasCageMovies)
        }

*/

        val callback = object : retrofit2.Callback<GitHubResult>{

            override fun onFailure(call: Call<GitHubResult>, t: Throwable) {
                println("t: " + t.message)
            }

            override fun onResponse(call: Call<GitHubResult>, response: Response<GitHubResult>) {
                println("response: " + response)

                //title = response?.body()?.city?.name

                /*
                rcl_forecast.apply {
                    adapter = response?.body()?.list?.let { WeatherListAdapter(it) }
                }
                */
            }

        }

        var searchTerm = intent.extras?.getString("searchTerm")

        if(searchTerm == ""){
            searchTerm = "Madrid"
        }

        var retriever = GitHubRetriever()
        retriever.searchRepos(callback, searchTerm!!)

    }
}
