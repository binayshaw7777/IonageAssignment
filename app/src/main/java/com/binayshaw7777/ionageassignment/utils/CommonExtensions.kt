package com.binayshaw7777.ionageassignment.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.tapadoo.alerter.Alerter


@SuppressLint("ServiceCast")
fun Context.checkForInternet(): Boolean {

    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val network = connectivityManager.activeNetwork ?: return false

    val activeNetwork =
        connectivityManager.getNetworkCapabilities(network) ?: return false

    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        else -> false
    }
}

fun Activity.showAlerter(title: String, message: String, color: Int, drawable: Int, timing: Long) {
    Alerter.create(this)
        .setTitle(title)
        .setText(message)
        .setBackgroundColorInt(color)
        .setIcon(drawable)
        .setDuration(timing)
        .show()
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun Context.showKeyboard(mEtSearch: EditText) {
    mEtSearch.requestFocus()
    val imm: InputMethodManager =
        this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(mEtSearch, 0)
}

fun Activity.hideKeyboard() {
    val view: View? = this.currentFocus
    view?.let {
        val imm =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}