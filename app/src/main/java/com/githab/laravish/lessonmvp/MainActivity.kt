package com.githab.laravish.lessonmvp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.githab.laravish.lessonmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        buttonOnClickListener()
    }

    private fun buttonOnClickListener() = with(binding) {
        btnOne.setOnClickListener(listener)
        btnTwo.setOnClickListener(listener)
        btnThree.setOnClickListener(listener)
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }

    private val listener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnOne -> presenter.onCounterClickOne()
            R.id.btnTwo -> presenter.onCounterClickTwo()
            R.id.btnThree -> presenter.onCounterClickThree()
        }
    }

    override fun setTextOne(counter: String) = with(binding) {
        textViewOne.text = counter
    }

    override fun setTextTwo(counter: String) = with(binding) {
        textViewTwo.text = counter
    }

    override fun setTextThree(counter: String) = with(binding) {
        textViewThree.text = counter
    }

}