package com.bitala.myapplication.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.bitala.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat


class CalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight:Int = 60
    private var currentAge:Int = 20
    private var currentHeight:Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    private lateinit var btnSubtract: FloatingActionButton
    private lateinit var btnPlus: FloatingActionButton
    private lateinit var tvWeight: TextView

    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView

    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        changeGender()
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.male)
        viewFemale = findViewById(R.id.female)

        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

        btnSubtract = findViewById(R.id.btnSubtract)
        btnPlus = findViewById(R.id.btnPLus)
        tvWeight = findViewById(R.id.tvWeight)

        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        tvAge = findViewById(R.id.tvAge)

        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm "
        }
        btnPlus.setOnClickListener{
            currentWeight +=1
            setWeight()
        }
        btnSubtract.setOnClickListener{
            currentWeight -=1
            setWeight()
        }
        btnPlusAge.setOnClickListener(){
            currentAge+=1
            setAge()
        }
        btnSubtractAge.setOnClickListener(){
            currentAge-=1
            setAge()
        }
        btnCalculate.setOnClickListener(){
             val result = calculateIMC()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()

    }

    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }


    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }

                                    //Recibe un boolean         Retorna un int
    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int{

        val colorReference = if(isSelectedComponent){
            //esta es una referencia al color mas no el color
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
          //Aqui se retorna el verdadero color
        return ContextCompat.getColor(this, colorReference)
    }

}