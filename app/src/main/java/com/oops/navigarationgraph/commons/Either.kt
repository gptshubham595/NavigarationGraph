package com.oops.navigarationgraph.commons;

sealed class Either<out L, out R> where L : IFailure {
    data class Error<out L : IFailure>(val failure: L) : Either<L, Nothing>()
    data class Success<out R>(val data: R) : Either<Nothing, R>()
}

