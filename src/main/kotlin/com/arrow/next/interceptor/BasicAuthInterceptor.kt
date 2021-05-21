package com.arrow.next.interceptor

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder().apply {
                addHeader("Authorization", auth)
            }.build()
        return chain.proceed(request)
    }
    private val auth = Credentials.basic("tester", "123\$\$tester@")
}