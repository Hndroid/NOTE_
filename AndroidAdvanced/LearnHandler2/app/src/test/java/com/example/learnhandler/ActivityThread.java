package com.example.learnhandler;

import android.os.Messenger;

import com.example.learnhandler.core.Handler;
import com.example.learnhandler.core.Looper;
import com.example.learnhandler.core.Message;

import org.junit.Test;

/**
 * @Date：2019/11/7
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc: 下面我们模拟 Android 系统的 ActivityThread#main()
 */
public class ActivityThread {


    @Test
    public void main(){


        // 1. 获取当前线程唯一的 Looper 实例
        Looper.prepare();

        // 2. 通过 Handle 消费消息
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //里面处理消息
                System.out.println(msg.obj);
            }
        };

        // 3. 在子线程发送 Message
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1;
                msg.obj = "I am a msg";
                handler.sendMessage(msg);
            }
        }).start();

        // 4. 开启 Looper#loop() 轮询
        Looper.loop();
    }
}
