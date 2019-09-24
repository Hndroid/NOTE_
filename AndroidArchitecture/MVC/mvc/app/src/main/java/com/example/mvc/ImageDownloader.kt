package com.example.mvc

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.HttpURLConnection
import java.net.URL

/**
 * @Date：2019/9/23
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc:
 */
class ImageDownloader(val callback: Callback, val imageBean: ImageBean) {

    companion object {
        const val SUCCESS = 200
        const val ERROR = 404
    }

    fun download() {

        Thread(object : Runnable {
            override fun run() {

                val url = URL(imageBean.requestPath)

                val httpURLConnection = url.openConnection() as HttpURLConnection

                httpURLConnection.connectTimeout = 3000
                httpURLConnection.requestMethod = "GET"

                if (httpURLConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = httpURLConnection.inputStream

                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    showUi(SUCCESS, bitmap)
                } else {
                    showUi(ERROR, null)
                }

            }
        }).start()

    }

    private fun showUi(requestCode: Int, bitmap: Bitmap?) {
        if (callback != null) {
            imageBean.bitmap = bitmap
            callback.callback(requestCode, imageBean)
        }
    }


}