package com.githab.laravish.lessonmvp.user

import com.githab.laravish.lessonmvp.cor.nav.DetailsUsersScreen
import com.githab.laravish.lessonmvp.repository.impl.GithubRepositoryImpl
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserPresenter(
    private val githubRepo: GithubRepositoryImpl, private val router: Router,
) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        githubRepo.getUsers()
            .subscribe({
                       viewState.initList(it)
                viewState.hideLoading()
            },{
                it.printStackTrace()
            })
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun onItemClicked(login: String) {
        router.navigateTo(DetailsUsersScreen(login))
    }
}