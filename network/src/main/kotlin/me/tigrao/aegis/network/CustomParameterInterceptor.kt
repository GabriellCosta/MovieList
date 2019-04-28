package me.tigrao.aegis.network

import okhttp3.Interceptor
import okhttp3.Response

internal class CustomParameterInterceptor(private val pair: Pair<String, String>) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(pair.first, pair.second)
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
