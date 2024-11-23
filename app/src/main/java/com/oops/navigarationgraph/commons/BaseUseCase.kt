package com.oops.navigarationgraph.commons

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

interface BaseUseCase<in Params, out Result> where Result : Any? {

    suspend fun run(params: Params): Either<IFailure, Result>

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (Result) -> Unit,
        onFailure: (IFailure) -> Unit
    ) {
        val job = scope.async { (run(params)) }

        scope.launch(Dispatchers.IO) {
            when (val result = job.await()) {
                is Either.Error -> {
                    onFailure(result.failure)
                }

                is Either.Success -> {
                    onSuccess(result.data)
                }
            }
        }
    }
}