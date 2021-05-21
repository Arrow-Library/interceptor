package com.arrow.next.interceptor.provider

interface Authentication {
    val xAccessToken: String
    val xDeviceName: String
    val xDeviceVersion: String
    val xAppVersion: String
    val xDeviceID: String
    val xDevice: String
    val xAccept: String
    val xContentType: String
}