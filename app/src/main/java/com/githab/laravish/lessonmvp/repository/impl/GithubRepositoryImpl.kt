package com.githab.laravish.lessonmvp.repository.impl

import com.githab.laravish.lessonmvp.model.GithubUser
import com.githab.laravish.lessonmvp.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val listUsers = listOf(GithubUser("Fox"),
        GithubUser("DOX"),
        GithubUser("Star"),
        GithubUser("Vish"))

    override fun getUsers() = listUsers
}