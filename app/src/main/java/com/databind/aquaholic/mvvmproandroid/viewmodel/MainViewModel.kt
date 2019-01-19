package com.databind.aquaholic.mvvmproandroid.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import com.databind.aquaholic.mvvmproandroid.model.OnRepositoryReadyCallback
import com.databind.aquaholic.mvvmproandroid.model.RepoModel
import com.databind.aquaholic.mvvmproandroid.model.Repository

class MainViewModel : ViewModel() {
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var repositories = ArrayList<Repository>()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onRepositoryReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories = data
                Log.d("myLog", repositories.first().repositoryName)
            }
        })
    }
}