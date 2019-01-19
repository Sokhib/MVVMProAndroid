package com.databind.aquaholic.mvvmproandroid.model

import android.os.Handler

class RepoModel {
    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100, false))
        arrayList.add(Repository("Second", "Owner 2", 30, true))
        arrayList.add(Repository("Third", "Owner 3", 430, false))
        Handler().postDelayed({
            onRepositoryReadyCallback.onRepositoryReady(arrayList)
        }, 2000)
    }
}

interface OnRepositoryReadyCallback {
    fun onRepositoryReady(data: ArrayList<Repository>)
}