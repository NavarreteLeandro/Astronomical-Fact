package com.example.firstmacapplication.viewModel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import com.example.firstmacapplication.httpRequest.RequestHttp
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.InputStream
import java.lang.Exception

class NasaViewModel {

    private val allData = RequestHttp.getRequest()

    private val jsonData : JsonObject = stringToJson(allData)

    private var date = jsonData.get("date").asString

    private var title = jsonData.get("title").asString

    private var hdUrl = jsonData.get("hdurl").asString

    private var explanation = jsonData.get("explanation").asString

    fun returnExplanation() : String{
        return explanation
    }

    fun returnDate() : String{
        return date
    }

    fun returnTitle() : String{
        return title
    }

    fun returnHdUrl() : String{
        return hdUrl
    }

    fun stringToJson(allData: String): JsonObject {

        var jsonElement = JsonParser.parseString(allData).asJsonObject

        return jsonElement

    }

     class DownlandImageTask constructor(imageView: ImageView): AsyncTask<String, Void, Bitmap>() {

        private var TAG : String = "DoenlandImageTask"
         val image : ImageView = imageView

        override fun doInBackground(vararg params: String?): Bitmap {

            var urlDisplay  = params[0]
            lateinit var bmp : Bitmap

            try {

                var input : InputStream = java.net.URL(urlDisplay).openStream()
                bmp = BitmapFactory.decodeStream(input)
            }catch (e : Exception){
                Log.e(TAG, e.message)
                e.printStackTrace()
            }
            return bmp
        }

        override fun onPostExecute(result: Bitmap?) {
            image.setImageBitmap(result)
        }
    }
}