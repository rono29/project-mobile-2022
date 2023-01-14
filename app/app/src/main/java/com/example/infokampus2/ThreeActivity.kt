package com.example.infokampus2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ThreeActivity : AppCompatActivity() {
    var btnStart: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
    }
        fun tologin(view: View?) {
            val i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)
        }
}
