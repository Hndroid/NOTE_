package com.example.mvc

import android.graphics.Bitmap

/**
 * [requestPath] 网络图片地址
 * [bitmap] 结果返回的 bitmap 对象
 */
data class ImageBean (var requestPath: String, var bitmap: Bitmap?)
