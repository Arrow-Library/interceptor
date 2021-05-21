package com.arrow.next.interceptor


import com.arrow.next.interceptor.provider.Authentication
import com.arrow.next.interceptor.provider.Token
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val auth: Authentication,
    private val token: Token
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder().apply {
                addHeader("X-Access-Token", auth.xAccessToken)
                addHeader("X-Device-Name", auth.xDeviceName)
                addHeader("X-OS-Version", auth.xDeviceVersion)
                addHeader("X-App-Version", auth.xAppVersion)
                addHeader("X-Device-ID", auth.xDeviceID)
                addHeader("X-Device", auth.xDevice)
                addHeader("Accept", auth.xAccept)
                addHeader("Content-type", auth.xContentType)
            }.build()
        val response = chain.proceed(request)
        if (response.code == 401) {
            token.invalidToken()
        }
        return response
    }
}
