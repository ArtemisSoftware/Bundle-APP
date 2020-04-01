package com.artemissoftware.bundleapp.gitrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GitRepoListAdapter (private var list: List<Repo>, private val mListener: (Repo) -> Unit) : RecyclerView.Adapter<GitRepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GitRepoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(list.get(position))

        holder.itemView.setOnClickListener {
            list.get(position)?.let { it1 -> mListener.invoke(it1) }
        }

    }

    override fun getItemCount(): Int = list.size

}