package com.bitala.myapplication.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bitala.myapplication.R
import com.bitala.myapplication.imccalculator.CalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private lateinit var tvResult: TextView
    private lateinit var tvInfo: TextView

    private lateinit var btnRecalculate: TextView

    //val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        //val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        //initListeners()
        initUI()
    }

    private fun initUI(){
        setResult()
    }

    private fun initComponents(){

        tvStatus = findViewById((R.id.tvResult))
        tvResult = findViewById(R.id.tvResult)
        tvInfo = findViewById(R.id.tvInfo)

        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners(){

    }


    private fun setResult(){
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        tvResult.text = result.toString()
        setStatus(result)
    }

    private fun setStatus(){
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }

    fun setStatus(result: Double) = when(result){
        in 18..25 ->  "Normal"
        in 26..30 ->   "Sobrepeso"
        in 31..35 ->   "Obesidad"
        else ->  "dawda"
    }
    private fun setInfo(){

    }
}