package com.githab.laravish.lessonmvp.main

import com.githab.laravish.lessonmvp.cor.nav.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val screen: UsersScreen) :
    MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.users())
    }

    fun onBackPressed() {
        router.exit()
    }
}