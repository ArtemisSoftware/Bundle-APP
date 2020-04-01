package com.artemissoftware.bundleapp.gitrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R
import com.squareup.picasso.Picasso

class GitRepoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :

    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_repo, parent, false)) {

    private var avatar: ImageView? = null
    private var description: TextView? = null

    init {
        avatar = itemView.findViewById(R.id.avatar)
        description = itemView.findViewById(R.id.description)
    }

    fun bind(repo: Repo) {

        Picasso.get().load(repo.owner.avatar_url).into(avatar);

        //avatar?.setImageURI() = weather.main
        description?.text = repo.full_name
    }

}