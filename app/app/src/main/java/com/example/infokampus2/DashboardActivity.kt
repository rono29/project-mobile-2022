package com.example.infokampus2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.infokampus2.databinding.FragmentUserBinding

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun negeri(view: View?) {
        val i = Intent(applicationContext, NegeriActivity::class.java)
        startActivity(i)
    }
    fun swasta(view: View?) {
        val i = Intent(applicationContext, SwastaActivity::class.java)
        startActivity(i)
    }
    fun profil(view: View?){
        val i = Intent(applicationContext, FragmentUserBinding::class.java)
        startActivity(i)
    }
}

