package me.tigrao.movielist.util

import android.content.Context
import android.net.ConnectivityManager

internal class NetworkAvailable(context: Context) {

    val isNetworkAvailable = isNetworkAvailable(context)

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
