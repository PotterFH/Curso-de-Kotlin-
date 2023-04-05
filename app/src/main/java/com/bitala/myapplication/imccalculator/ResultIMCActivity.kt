package com.bitala.myapplication.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitala.myapplication.R
import com.bitala.myapplication.imccalculator.CalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}