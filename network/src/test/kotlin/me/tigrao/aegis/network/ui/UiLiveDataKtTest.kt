package me.tigrao.aegis.network.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UiLiveDataKtTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    val liveData = MutableLiveData<UiState<Unit>>()
    val lifecycleRegistry = LifecycleRegistry(mock())

    lateinit var lifecycleOwner: LifecycleOwner

    @Before
    fun setup() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        lifecycleOwner = LifecycleOwner { lifecycleRegistry }
    }

    @Test
    fun givenObserverLoading_whenPosting_ShouldNotTriggerForSuccess() {
        val observer = mock<() -> Unit>()
        liveData.observeOnLoading(lifecycleOwner, observer)

        liveData.postValue(UiSuccess(Unit))

        verify(observer, never()).invoke()
    }

    @Test
    fun givenObserverLoading_whenPosting_ShouldNotTriggerForError() {
        val observer = mock<() -> Unit>()
        liveData.observeOnLoading(lifecycleOwner, observer)

        liveData.postValue(UiError(ErrorData(Exception())))

        verify(observer, never()).invoke()
    }

    @Test
    fun givenObserverLoading_whenPosting_ShouldTriggerForLoading() {
        val observer = mock<() -> Unit>()
        liveData.observeOnLoading(lifecycleOwner, observer)

        liveData.postValue(UiLoading)

        verify(observer).invoke()
    }

    @Test
    fun givenObserverError_whenPosting_ShouldNotTriggerForSuccess() {
        val observer = mock<(ErrorData) -> Unit>()
        liveData.observeOnError(lifecycleOwner, observer)

        liveData.postValue(UiSuccess(Unit))

        verify(observer, never()).invoke(any())
    }

    @Test
    fun givenObserverError_whenPosting_ShouldNotTriggerForLoading() {
        val observer = mock<(ErrorData) -> Unit>()
        liveData.observeOnError(lifecycleOwner, observer)

        liveData.postValue(UiLoading)

        verify(observer, never()).invoke(any())
    }

    @Test
    fun givenObserverError_whenPosting_ShouldTriggerForError() {
        val observer = mock<(ErrorData) -> Unit>()
        liveData.observeOnError(lifecycleOwner, observer)

        liveData.postValue(UiError(ErrorData(Exception())))

        verify(observer).invoke(any())
    }

    @Test
    fun givenObserverSuccessWithParameter_whenPosting_ShouldTriggerForSuccess() {
        val observer = mock<(Unit) -> Unit>()
        liveData.observeOnSuccess(lifecycleOwner, observer)

        liveData.postValue(UiSuccess(Unit))

        verify(observer).invoke(any())
    }

    @Test
    fun givenObserverSuccessWithParameter_whenPosting_ShouldNotTriggerForError() {
        val observer = mock<(Unit) -> Unit>()
        liveData.observeOnSuccess(lifecycleOwner, observer)

        liveData.postValue(UiError(ErrorData(Exception())))

        verify(observer, never()).invoke(any())
    }

    @Test
    fun givenObserverSuccessWithParameter_whenPosting_ShouldNotTriggerForLoading() {
        val observer = mock<(Unit) -> Unit>()
        liveData.observeOnSuccess(lifecycleOwner, observer)

        liveData.postValue(UiLoading)

        verify(observer, never()).invoke(any())
    }

    @Test
    fun givenObserverSuccess_whenPosting_ShouldTriggerForSuccess() {
        val observer = mock<() -> Unit>()
        liveData.observeOnSuccess(lifecycleOwner, observer)

        liveData.postValue(UiSuccess(Unit))

        verify(observer).invoke()
    }

    @Test
    fun givenObserverSuccess_whenPosting_ShouldNotTriggerForError() {
        val observer = mock<() -> Unit>()
        liveData.observeOnSuccess(lifecycleOwner, observer)

        liveData.postValue(UiError(ErrorData(Exception())))

        verify(observer, never()).invoke()
    }

    @Test
    fun givenObserverSuccess_whenPosting_ShouldNotTriggerForLoading() {
        val observer = mock<() -> Unit>()
        liveData.observeOnSuccess(lifecycleOwner, observer)

        liveData.postValue(UiLoading)

        verify(observer, never()).invoke()
    }
}
