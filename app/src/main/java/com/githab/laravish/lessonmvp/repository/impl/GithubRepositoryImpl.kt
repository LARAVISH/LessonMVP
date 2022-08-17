package com.githab.laravish.lessonmvp.repository.impl

import com.githab.laravish.lessonmvp.model.GithubUser
import com.githab.laravish.lessonmvp.repository.GithubRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class GithubRepositoryImpl : GithubRepository {

    private val listUsers = listOf(GithubUser(1, "Fox"),
        GithubUser(2, "DOX"),
        GithubUser(3, "Star"),
        GithubUser(4, "Vish"))

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(listUsers)
        }
            .delay(3000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getUserByLogin(login: String): Single<GithubUser>? {
        return Single.create {
            listUsers.find { it.login == login }?.let { it1 -> it.onSuccess(it1) }
        }
            .delay(2000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }
}
