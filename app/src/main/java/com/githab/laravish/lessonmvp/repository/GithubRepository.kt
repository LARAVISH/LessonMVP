package com.githab.laravish.lessonmvp.repository

import com.githab.laravish.lessonmvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers() : Single<List<GithubUser>>
    fun getUserByLogin(login : String) : Single<GithubUser>?




}