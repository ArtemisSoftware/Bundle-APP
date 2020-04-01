package com.artemissoftware.bundleapp.gitrepo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Response

class RepoSearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_search_result)

        var rcl_repos = findViewById<RecyclerView>(R.id.rcl_repos)

        rcl_repos.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            //adapter = WeatherListAdapter(mNicolasCageMovies)
        }



        val callback = object : retrofit2.Callback<GitHubResult>{

            override fun onFailure(call: Call<GitHubResult>, t: Throwable) {
                println("t: " + t.message)
            }

            override fun onResponse(call: Call<GitHubResult>, response: Response<GitHubResult>) {
                println("response: " + response)

                if(response?.code() == 404){

                    val theView = this@RepoSearchResultActivity.findViewById<View>(android.R.id.content)

                    Snackbar.make(theView, response?.message(), Snackbar.LENGTH_LONG).show();
                }
                else {
                    rcl_repos.apply {
                        adapter = response?.body()?.items?.let {
                            GitRepoListAdapter(
                                it,
                                { repo -> openUrl(repo) })
                        }
                    }
                }
            }
        }


        val callbackUser = object : retrofit2.Callback<List<Repo>>{

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                println("t: " + t.message)
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                println("response: " + response)

                if(response?.code() == 404){
                    val theView = this@RepoSearchResultActivity.findViewById<View>(android.R.id.content)

                    Snackbar.make(theView, response?.message(), Snackbar.LENGTH_LONG).show();
                }
                else {
                    rcl_repos.apply {
                        adapter = response?.body()
                            ?.let { GitRepoListAdapter(it, { repo -> openUrl(repo) }) }
                    }
                }
            }
        }

        var searchTerm = intent.extras?.getString("searchTerm")


        var retriever = GitHubRetriever()

        if(intent.extras?.getInt("typeSearch") == 0) {

            retriever.searchRepos(callback, searchTerm!!)
        }
        else{
            retriever.searchUser(callbackUser, searchTerm!!)
        }

    }

    private fun openUrl(repo: Repo) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(repo.html_url));
        startActivity(intent)
    }
}
