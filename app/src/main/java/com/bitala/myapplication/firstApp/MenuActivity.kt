package com.bitala.myapplication.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.bitala.myapplication.R
import com.bitala.myapplication.imccalculator.CalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludaApp = findViewById<AppCompatButton>(R.id.btnSaludaApp)
        btnSaludaApp.setOnClickListener{ navigateToSaludApp() }

        val btnImcApp = findViewById<AppCompatButton>(R.id.btnIMCApp)
        btnImcApp.setOnClickListener{ navigateToIMCApp()}

    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstApp::class.java)
        startActivity(intent)
    }
}