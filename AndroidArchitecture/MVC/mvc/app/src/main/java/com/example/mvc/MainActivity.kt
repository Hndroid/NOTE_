package com.example.mvc

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Callback {

    companion object{
        const val PATH = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569225130327&di=c6805e1ef90be37ce1fbdfcd2fa363b8&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F1802%2F178-1P2031F312.jpg"
    }

    override fun callback(resultCode: Int, imageBean: ImageBean) {
        val obtainMessage = handler.obtainMessage(resultCode);
        obtainMessage.obj = imageBean.bitmap;
        handler.sendMessageAtTime(obtainMessage, 2000)
    }

    private val handler = Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {

            when (msg.what) {
                ImageDownloader.SUCCESS -> {
                    imageView.setImageBitmap(msg.obj as Bitmap?)
                }
                ImageDownloader.ERROR -> {
                    Toast.makeText(this@MainActivity, "下载失败", Toast.LENGTH_SHORT).show()
                }
            }

            return false
        }
    })

    //网络请求
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadImageView.setOnClickListener {
            ImageDownloader(this, ImageBean(PATH, null)).download()
        }
    }


}
