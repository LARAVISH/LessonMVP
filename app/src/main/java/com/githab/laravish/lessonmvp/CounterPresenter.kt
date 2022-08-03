package com.githab.laravish.lessonmvp

class CounterPresenter(private val view: MainView) {

    private val model = CounterModel()

    fun onCounterClickOne() {
        view.setTextOne((model.nextPosition(POSITION_ONE).toString()))
    }

    fun onCounterClickTwo() {
        view.setTextTwo((model.nextPosition(POSITION_TWO).toString()))
    }

    fun onCounterClickThree() {
        view.setTextThree((model.nextPosition(POSITION_THREE).toString()))
    }

}

