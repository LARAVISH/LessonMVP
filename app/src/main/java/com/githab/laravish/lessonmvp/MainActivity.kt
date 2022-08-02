package com.githab.laravish.lessonmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.githab.laravish.lessonmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

        with(binding) {
            btnOne.setOnClickListener { textViewOne.text = "${++counters[0]}" }
            btnTwo.setOnClickListener { textViewTwo.text = "${++counters[1]}" }
            btnThree.setOnClickListener { textViewThree.text = "${++counters[2]}" }
        }
    }

    private fun initView() = with(binding) {
        textViewOne.text = "${counters[0]}"
        textViewTwo.text = "${counters[1]}"
        textViewThree.text = "${counters[2]}"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("KEY", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val array = savedInstanceState.getIntArray("KEY")
        counters.let { list ->
            list.clear()
            array?.toList()?.let {
                list.addAll(it)
            }
        }
        initView()
    }
}