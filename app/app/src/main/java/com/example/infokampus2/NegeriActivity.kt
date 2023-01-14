package com.example.infokampus2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infokampus2.view.PhotoListAdapter
import com.example.infokampus2.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class NegeriActivity : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}