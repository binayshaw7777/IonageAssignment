package com.binayshaw7777.ionageassignment.utils

import android.util.Log
import com.airbnb.lottie.BuildConfig

object Logger {

    fun debugLog(tag: String?, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg!!)
        }
    }

    fun debugLog(msg: String?) {
            Log.d("", msg!!)

    }

    fun Any.debugLog(tag: String? = "DEBUG_TAG") {
        Log.d(tag, toString())
    }

//    fun debugLog(msg: String?) {
//        if (BuildConfig.DEBUG) {
//            Log.d("Log", msg!!)
//        }
//    }

    fun logException(tag: String, exception: Exception, logLevel: LogLevel, logToCrashlytics : Boolean = false) {
        when (logLevel) {
            LogLevel.DEBUG -> Log.d(tag, null, exception)
            LogLevel.ERROR -> Log.e(tag, null, exception)
            LogLevel.INFO -> Log.i(tag, null, exception)
            LogLevel.VERBOSE -> Log.v(tag, null, exception)
            LogLevel.WARN -> Log.w(tag, null, exception)
        }
        if (logToCrashlytics) {
            //TODO: send log to crashlytics like Firebase
        }
    }

    enum class LogLevel {
        DEBUG, ERROR, INFO, VERBOSE, WARN
    }
}