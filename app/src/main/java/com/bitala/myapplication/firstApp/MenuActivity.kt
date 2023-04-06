package com.bitala.myapplication.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.bitala.myapplication.R
import com.bitala.myapplication.imccalculator.CalculatorActivity
import com.bitala.myapplication.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludaApp = findViewById<AppCompatButton>(R.id.btnSaludaApp)
        btnSaludaApp.setOnClickListener{ navigateToSaludApp() }

        val btnImcApp = findViewById<AppCompatButton>(R.id.btnIMCApp)
        btnImcApp.setOnClickListener{ navigateToIMCApp()}

        val btnTODOApp = findViewById<AppCompatButton>(R.id.btnTODOApp)
        btnTODOApp.setOnClickListener{ navigateToTodoApp() }


    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
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