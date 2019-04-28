package me.tigrao.aegis.network

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY_PARAMETER = "api_key"

internal class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY_PARAMETER, "1f54bd990f1cdfb230adb312546d765d")
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
