package me.tigrao.aegis.network

private const val API_KEY_PARAMETER = "api_key"
private const val LANGUAGE_PARAMETER = "language"

internal fun apiKeyInterceptor() =
    CustomParameterInterceptor(API_KEY_PARAMETER to "1f54bd990f1cdfb230adb312546d765d")

internal fun languageInterceptor() =
    CustomParameterInterceptor(LANGUAGE_PARAMETER to "pt-BR")
