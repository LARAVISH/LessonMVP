package com.githab.laravish.lessonmvp.repository.impl

import com.githab.laravish.lessonmvp.model.GithubUser
import com.githab.laravish.lessonmvp.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val listUsers = listOf(GithubUser(1, "Fox"),
        GithubUser(2, "DOX"),
        GithubUser(3, "Star"),
        GithubUser(4, "Vish"))

    override fun getUsers() = listUsers

    override fun getUserByLogin(login: String): GithubUser? {
        return listUsers.find { it.login == login }
    }
}