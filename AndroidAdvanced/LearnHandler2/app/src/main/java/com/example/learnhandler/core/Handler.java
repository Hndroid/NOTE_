package com.example.learnhandler.core;

/**
 * @Date：2019/11/7
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc:
 */
public class Handler {

    private MessageQueue mQueue;
    private Looper mLooper;

    public Handler(){
        mLooper = Looper.myLooper();
        //在 Looper 里面维护着一个 MessageQueue 实例；
        mQueue = mLooper.mQueue;
    }

    // 该 API 用于暴露给用户，用户重写该 API 来处理消息
    public void handleMessage(Message msg){

    }


    public void sendMessage(Message msg) {
        //在这里进行消息队列 MessageQueue 的压队, 首先进行把信息压进队列 MessageQueue
        //注意，在压队之前，需要把当前的 Handler 实例和 Message 进行绑定
        msg.target = this;
        mQueue.enqueueMessage(msg);

    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }
}
