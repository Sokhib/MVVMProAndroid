package com.databind.aquaholic.mvvmproandroid.model

class Repository(
    var repositoryName: String,
    var repositoryOwner: String?,
    var numberOfStars: Int?,
    var hasIssues: Boolean = false
)