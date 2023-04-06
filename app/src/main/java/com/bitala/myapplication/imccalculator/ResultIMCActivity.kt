package com.bitala.myapplication.imccalculator

import android.content.Intent
import android.graphics.Color
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
        initListeners()
        initUI()
    }

    private fun initUI(){
        setResult()
        setStatus()
        setInfo()
    }


    private fun initComponents(){

        tvStatus = findViewById((R.id.tvStatus))
        tvResult = findViewById(R.id.tvResult)
        tvInfo = findViewById(R.id.tvInfo)

        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners(){

        btnRecalculate.setOnClickListener(){
            navigateToCalculate()
        }

    }

    private fun navigateToCalculate() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun setResult(){
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        tvResult.text = result.toString()
    }

    private fun setStatus(){
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        if(result <= 24.9){
            tvStatus.text = "Normal"
            tvStatus.setTextColor(Color.parseColor("#67C500"))
        }else if (result <= 29.9){
            tvStatus.text = "Sobrepeso"
            tvStatus.setTextColor(Color.parseColor("#F89800"))
        }else if( result >= 30){
            tvStatus.text = "Obesidad"
            tvStatus.setTextColor(Color.parseColor("#F82C00"))

        }

    }

    private fun setInfo(){
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        if(result <= 24.9){
            tvInfo.text = "Te encuentras con un IMC normal sigue commiendo sano"
            tvInfo.setTextColor(Color.parseColor("#67C500"))
        }else if (result <= 29.9){
            tvInfo.text = "Estas un poco pasado de IMC normal, se recomienda bajarle a los tacos"
            tvInfo.setTextColor(Color.parseColor("#F89800"))

        }else if( result >= 30){
           tvInfo.text = "Tu IMC es demasiado alto ya no puedes comer ni un taco mas"
            tvInfo.setTextColor(Color.parseColor("#F82C00"))

        }
    }
}