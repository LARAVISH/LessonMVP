package com.githab.laravish.lessonmvp

import android.os.Bundle
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

        with(binding) {
            btnOne.setOnClickListener { presenter.onCounterClick(R.id.btnOne) }
            btnTwo.setOnClickListener { presenter.onCounterClick(R.id.btnTwo) }
            btnThree.setOnClickListener { presenter.onCounterClick(R.id.btnThree) }
        }
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }

    override fun setText(counter: String, position: Int) = with(binding) {
        when (position) {
            0 -> textViewOne.text = counter
            1 -> textViewTwo.text = counter
            2 -> textViewThree.text = counter
        }
    }
}