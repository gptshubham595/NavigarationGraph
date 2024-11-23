package com.oops.navigarationgraph.commons;

data class ErrorModel(
    val errorMessage: String = "",
    val errorTitle: String,
    val exception: Exception? = null
) : Throwable()
