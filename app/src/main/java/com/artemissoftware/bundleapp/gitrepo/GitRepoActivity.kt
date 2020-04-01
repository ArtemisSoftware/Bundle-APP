package com.artemissoftware.bundleapp.gitrepo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.artemissoftware.bundleapp.R

class GitRepoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        (findViewById(R.id.searchButton) as Button).setOnClickListener{searchButton__OnClickListener(it)};
        (findViewById(R.id.searchUserButton) as Button).setOnClickListener{searchUserButton__OnClickListener(it)};
    }

    private fun searchButton__OnClickListener(it: View?) {

        val intent = Intent(getApplicationContext(), RepoSearchResultActivity::class.java)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        intent.putExtra("searchTerm", searchEditText.text.toString())
        intent.putExtra("typeSearch", 0)
        startActivity(intent)
    }


    private fun searchUserButton__OnClickListener(it: View?) {

        val intent = Intent(getApplicationContext(), RepoSearchResultActivity::class.java)

        val searchEditText = findViewById<EditText>(R.id.searchUserEditText)
        intent.putExtra("searchTerm", searchEditText.text.toString())
        intent.putExtra("typeSearch", 1)
        startActivity(intent)
    }
}
