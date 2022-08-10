package com.githab.laravish.lessonmvp.cor.nav

import com.githab.laravish.lessonmvp.user.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen : Screens {
    override fun users() = FragmentScreen {
        UsersFragment.newInstance()
    }
}