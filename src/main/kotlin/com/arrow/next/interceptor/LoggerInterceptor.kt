package com.arrow.next.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class LoggerInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        print("Response code: ${response.code}")
        return response
    }
}