package com.binayshaw7777.ionageassignment.utils

fun String.showDotStringAfterLimitReached(length: Int) : String {
    val stringBuilder = StringBuilder()
    if (length > this.length) return this
    Logger.debugLog("string: $this")
    for (i in 0 until length) {
        stringBuilder.append(this[i])
    }

    return stringBuilder.append("...").toString()
}