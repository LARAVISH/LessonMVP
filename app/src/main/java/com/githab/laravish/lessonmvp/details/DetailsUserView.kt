package com.githab.laravish.lessonmvp.details

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsUserView : MvpView {
    fun showLogin(login: String)
}