package com.githab.laravish.lessonmvp.repository

import com.githab.laravish.lessonmvp.model.GithubUser

interface GithubRepository {
    fun getUsers() : List<GithubUser>
    fun getUserByLogin(login : String) :GithubUser?




}