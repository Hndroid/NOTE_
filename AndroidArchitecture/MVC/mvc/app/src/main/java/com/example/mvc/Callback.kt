package com.example.mvc

import android.graphics.Bitmap

/**
 * @Date：2019/9/23
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc:
 */
interface Callback {
    fun callback(resultCode: Int, imageBean: ImageBean)
}