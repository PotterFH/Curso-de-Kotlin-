package com.bitala.myapplication.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.bitala.myapplication.R.*

class FirstApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_first_app)
        val btnClick = findViewById<AppCompatButton>(id.btnClick)
        val etName = findViewById<AppCompatEditText>(id.etName)



        btnClick.setOnClickListener {
            val name = etName.text.toString()

            if(name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }

        }
    }
}