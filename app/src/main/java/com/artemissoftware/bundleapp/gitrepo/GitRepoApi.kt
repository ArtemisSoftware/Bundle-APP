package com.artemissoftware.bundleapp.gitrepo

import com.artemissoftware.bundleapp.weather.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitRepoApi {


    @GET("search/repositories?")
    fun searchRepos(@Query("q") searchTerm: String) : Call<GitHubResult>


    @GET("users/{user}/repos")
    fun searchUser(@Path("user") username: String) : Call<List<Repo>>


}

class GitHubResult(val items: List<Repo>)
class Repo(val full_name: String, val owner: GitHubUser, val html_url: String)
class GitHubUser(val avatar_url: String)



class GitHubRetriever{

    val service :  GitRepoApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(GitRepoApi::class.java)
    }

    fun searchRepos(callback : Callback<GitHubResult>, searchTerm: String){

        val call = service.searchRepos(searchTerm)

        call.enqueue(callback)
    }


    fun searchUser(callback : Callback<List<Repo>>, searchTerm: String){

        val call = service.searchUser(searchTerm)

        call.enqueue(callback)
    }
}