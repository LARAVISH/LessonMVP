package com.githab.laravish.lessonmvp

class CounterModel {
    private var counters = mutableListOf(ITEM_COUNTERS, ITEM_COUNTERS, ITEM_COUNTERS)

    fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun nextPosition(position: Int): Int {
        return counters[position]++
    }

    fun set(position: Int, value: Int): Boolean {
        counters[position] = value
        return true
    }
}