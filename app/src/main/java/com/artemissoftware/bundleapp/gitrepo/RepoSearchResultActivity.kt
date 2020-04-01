package com.artemissoftware.bundleapp.gitrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemissoftware.bundleapp.R

class RepoSearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_search_result)

        var searchTerm = intent.extras?.getString("searchTerm")
    }
}
