package com.example.infokampus2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TwoActivity : AppCompatActivity() {
    var btnNext: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
    }
        fun two(view: View?) {
            val i = Intent(applicationContext, ThreeActivity::class.java)
            startActivity(i)
    }
}