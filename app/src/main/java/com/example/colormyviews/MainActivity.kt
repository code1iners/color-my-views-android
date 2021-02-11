package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> = listOf(
                boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText,
                constraintLayout, redButton, yellowButton, greenButton
            )

            for (view in clickableViews) {
                view.setOnClickListener { makeColored(view) }
            }

            // note. before
//            val clickableViews: List<View> = listOf(
//                box_one_text, box_two_text, box_three_text,
//                box_four_text, box_five_text, constraint_layout,
//                red_button, yellow_button, green_button
//            )
//            for (item in clickableViews) {
//                item.setOnClickListener { makeColored(item) }
//            }
        }
    }

    private fun makeColored(view: View) {
        binding.apply {
            when (view) {
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)

                // Boxes using Android Color resources for background
                boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

                // Boxes using custom colors for background
                redButton -> box_three_text.setBackgroundResource(R.color.my_red)
                yellowButton -> box_four_text.setBackgroundResource(R.color.my_yellow)
                greenButton -> box_five_text.setBackgroundResource(R.color.my_green)

                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }

        // note. before
//        when (view.id) {
//            // Boxes using Color class colors for background
//            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
//            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
//
//            // Boxes using Android Color resources for background
//            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
//            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
//            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
//
//            // Boxes using custom colors for background
//            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
//            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
//            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)
//
//            else -> view.setBackgroundColor(Color.LTGRAY)
//        }
    }
}