package me.tigrao.aegis.network.ui

import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import java.util.concurrent.atomic.AtomicBoolean

internal class UiLiveData<T>(private val call: Call<T>) : MutableLiveData<UiState<T>>() {

    private var started = AtomicBoolean(false)

    override fun onActive() {
        super.onActive()
        if (started.compareAndSet(false, true))
            postValue(UiLoading)
        doCall()
    }

    private fun doCall() {
        if (!call.isExecuted)
            call.enqueue(UiStateCallback(this))
    }
}
