package com.databind.aquaholic.mvvmproandroid

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.databind.aquaholic.mvvmproandroid.databinding.ActivityMainBinding
import com.databind.aquaholic.mvvmproandroid.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.executePendingBindings()
    }

    override fun onItemClick(position: Int) {
        //Log.d("myLog", "$position")
    }
}
