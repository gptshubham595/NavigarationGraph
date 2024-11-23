package com.oops.navigarationgraph.commons

import android.util.Log
import com.oops.navigarationgraph.BuildConfig


sealed class Logger {
    data class Debug(val tag: String, val message: String) : Logger()
    data class Error(val tag: String, val message: String, val exception: Exception) : Logger()

    companion object {
        fun log(logger: Logger) {
            when (logger) {
                is Logger.Error -> {
                    if (BuildConfig.DEBUG)
                        Log.e(logger.tag, logger.message, logger.exception)
                }

                is Logger.Debug -> {
                    if (BuildConfig.DEBUG)
                        Log.e(logger.tag, logger.message)
                }
            }
        }

        fun d(TAG: String, msg: String) {
            log(Debug(TAG, msg))
        }

        fun e(TAG: String, msg: String, exception: Exception) {
            log(Error(TAG, msg, exception))
        }
    }
}