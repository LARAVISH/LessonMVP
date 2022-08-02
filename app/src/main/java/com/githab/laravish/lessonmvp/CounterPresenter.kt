package com.githab.laravish.lessonmvp

class CounterPresenter(private val view: MainView) {

    private val model = CounterModel()
    fun onCounterClick(id: Int) {
        when (id) {
            R.id.btnOne -> {
                val newValue = model.nextPosition(0)
                view.setText(newValue.toString(), 0)
            }
            R.id.btnTwo -> {
                val newValue = model.nextPosition(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnThree -> {
                val newValue = model.nextPosition(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}