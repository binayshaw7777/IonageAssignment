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

fun String.getBaseStringForFiltering(): String {
    val stringBuilder = StringBuilder()

    for (char in this.toCharArray()) {
        if (char.isLetter())
            stringBuilder.append(char)
    }

    return stringBuilder.toString()
}