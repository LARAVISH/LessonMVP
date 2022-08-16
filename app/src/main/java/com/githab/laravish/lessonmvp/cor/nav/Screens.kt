package com.githab.laravish.lessonmvp.cor.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.githab.laravish.lessonmvp.details.DetailsUserFragment
import com.githab.laravish.lessonmvp.user.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UsersFragment.newInstance()
    }
}

data class DetailsUsersScreen(val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsUserFragment.newInstance(login)
    }

}