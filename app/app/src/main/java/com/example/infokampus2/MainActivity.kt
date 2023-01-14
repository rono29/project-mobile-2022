package com.example.infokampus2


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.infokampus2.adapter.ViewPagerAdapter
import com.example.infokampus2.databinding.ActivityMain1Binding
import com.example.infokampus2.fragment.HomeFragment
import com.example.infokampus2.fragment.UserFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }
    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(),"Home")
        adapter.addFragment(UserFragment(),"User")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_user)
    }
//    fun negeri(view: View?) {
//        val i = Intent(applicationContext, NegeriActivity::class.java)
//        startActivity(i)
//    }
//    fun swasta(view: View?) {
//        val i = Intent(applicationContext, SwastaActivity::class.java)
//        startActivity(i)
//    }

}


