package com.example.firstmacapplication.httpRequest

import org.junit.Test

import org.junit.Assert.*

class RequestHttpTest {

    @Test
    fun getRequest() {
        assertNotEquals("No hay datos.", RequestHttp.getRequest())
    }
}