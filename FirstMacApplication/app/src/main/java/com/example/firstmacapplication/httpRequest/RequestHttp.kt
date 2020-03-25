package com.example.firstmacapplication.httpRequest

import com.github.kittinunf.fuel.httpGet

class RequestHttp() {
    companion object {

        private val TAG = "RequestHttp"
        private val url =
            "https://api.nasa.gov/planetary/apod?api_key=qDRpijiRA17I3D6BgMhAmq2Ga3O9TY3ZdW7rkObO"

        fun getRequest(): String {

            var stringResponse: String = ""

            val httpAsync = url
                .httpGet()
                .responseString { _, _, result ->
                    result.fold(success = { data ->
                        stringResponse = data
                    }, failure = {
                        val (_, error) = result
                        stringResponse = "No hay datos."
                    })
                }
            httpAsync.join()
            return stringResponse
        }

    }
}