package com.gregcoorp.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Numbers
        tvZero.setOnClickListener { appendOnExpression("0", true) }
        tvOne.setOnClickListener { appendOnExpression("1", true) }
        tvTwo.setOnClickListener { appendOnExpression("2", true) }
        tvThree.setOnClickListener { appendOnExpression("3", true) }
        tvFour.setOnClickListener { appendOnExpression("4", true) }
        tvFive.setOnClickListener { appendOnExpression("5", true) }
        tvSix.setOnClickListener { appendOnExpression("6", true) }
        tvSeven.setOnClickListener { appendOnExpression("7", true) }
        tvEight.setOnClickListener { appendOnExpression("8", true) }
        tvNine.setOnClickListener { appendOnExpression("9", true) }
        tvDot.setOnClickListener { appendOnExpression(".", true) }

        // Operators
        tvPlus.setOnClickListener { appendOnExpression("+", false) }
        tvMinus.setOnClickListener { appendOnExpression("-", false) }
        tvTimes.setOnClickListener { appendOnExpression("*", false) }
        tvDivide.setOnClickListener { appendOnExpression("/", false) }
        tvOpen.setOnClickListener { appendOnExpression("(", false) }
        tvClose.setOnClickListener { appendOnExpression(")", false) }

        // Clear
        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        // Delete
        tvBack.setOnClickListener {
            val string = tvExpression.text
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(startIndex = 0, endIndex = string.length-1)
            }
            tvResult.text = ""
        }

        // Equals
        tvEquals.setOnClickListener {
            tvResult.text = "result!"
        }

    }

    private fun appendOnExpression(string: String, canClear: Boolean) {
        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        }
        else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}
