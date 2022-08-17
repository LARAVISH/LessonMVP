package com.githab.laravish.lessonmvp.details

import com.githab.laravish.lessonmvp.repository.impl.GithubRepositoryImpl
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class DetailsUserPresenter(
    private val githubRepo: GithubRepositoryImpl, private val router: Router,
) : MvpPresenter<DetailsUserView>() {

    fun loadUser(login: String) {
        viewState.showLoading()
        githubRepo.getUserByLogin(login)
            ?.subscribe({
                viewState.showLogin(login)
                viewState.hideLoading()
            },
                {
                    it.printStackTrace()
                })
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}
