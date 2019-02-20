package me.tigrao.aegis.network.ui

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

fun <RESPONSE> LiveData<UiState<RESPONSE>>.observeOnLoading(
    owner: LifecycleOwner, observer: () -> Unit): LiveData<UiState<RESPONSE>> {
    observe(owner, Observer {
        if (it is UiLoading) observer.invoke()
    })
    return this
}

fun <RESPONSE> LiveData<UiState<RESPONSE>>.observeOnSuccess(
    owner: LifecycleOwner, observer: (RESPONSE) -> Unit): LiveData<UiState<RESPONSE>> {
    observe(owner, Observer {
        if (it is UiSuccess) observer.invoke(it.data)
    })
    return this
}

fun <RESPONSE> LiveData<UiState<RESPONSE>>.observeOnSuccess(
    owner: LifecycleOwner, observer: () -> Unit): LiveData<UiState<RESPONSE>> {
    observe(owner, Observer {
        if (it is UiSuccess) observer.invoke()
    })
    return this
}

fun <RESPONSE> LiveData<UiState<RESPONSE>>.observeOnError(
    owner: LifecycleOwner, observer: (ErrorData) -> Unit): LiveData<UiState<RESPONSE>> {
    observe(owner, Observer {
        if (it is UiError) observer.invoke(it.errorData)
    })
    return this
}