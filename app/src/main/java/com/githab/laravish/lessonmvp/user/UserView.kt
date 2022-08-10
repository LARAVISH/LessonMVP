package com.githab.laravish.lessonmvp.user

import com.githab.laravish.lessonmvp.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
    fun initList(list: List<GithubUser>)
}