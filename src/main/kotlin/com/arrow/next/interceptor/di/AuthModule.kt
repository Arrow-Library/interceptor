package com.arrow.next.interceptor.di

import com.arrow.next.interceptor.AuthInterceptor
import com.arrow.next.interceptor.BasicAuthInterceptor
import com.arrow.next.interceptor.LoggerInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module


val authProvider = module {
    single(named("interceptors")) {
        arrayListOf(
            AuthInterceptor(get(), get()),
            BasicAuthInterceptor(),
            LoggerInterceptor(),
        )
    }
}