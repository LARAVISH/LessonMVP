package com.githab.laravish.lessonmvp.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.githab.laravish.lessonmvp.R
import com.githab.laravish.lessonmvp.model.GithubUser

class UserAdapter : RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        return GithubUserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvLogin by lazy {
            itemView.findViewById<TextView>(R.id.tvUserLogin)
        }

        fun bind(item: GithubUser) = with(item) {
            tvLogin.text = login
        }
    }
}


