package com.example.infokampus2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infokampus2.view.PhotoListAdapter
import com.example.infokampus2.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class SwastaActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.data.observe(this, Observer{ data ->
            data?.let{
                photoListAdapter.updatePhotos(it)
            }
        })
    }
    fun back(view: View?) {
        val i = Intent(applicationContext, DashboardActivity::class.java)
        startActivity(i)
    }
    fun detail(view: View?){
        val i = Intent(applicationContext, univ::class.java)
        startActivity(i)
    }
}