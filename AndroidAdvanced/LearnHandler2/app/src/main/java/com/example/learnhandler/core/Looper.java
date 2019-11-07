package com.example.learnhandler.core;

/**
 * @Date：2019/11/7
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc:
 */
public class Looper {

    public MessageQueue mQueue;

    public Looper(){
        //初始化 MessageQueue
        mQueue = new MessageQueue();
    }

    //ThreadLocal 的结构是 <key, value>, key 对应为当前的线程，value 对应为该线程创建的 Looper 实例
    //作用：用于维护线程私有的 Looper 实例
    private static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    //下面我们通过模拟系统源码的 Looper#prepare()
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    //获取对应线程唯一的 Looper 实例
    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static void loop() {

        //获取 Looper 实例
        Looper me = myLooper();

        //获取对应的 MessageQueue 实例
        MessageQueue messageQueue = me.mQueue;

        //开启一个死循环读取队列里面的信息
        while (true){

            Message msg = messageQueue.next();

            if (msg != null){
                if (msg.target != null){
                    //通过对应的 Handle 实例模拟消息的分发
                    msg.target.dispatchMessage(msg);
                }
            }
        }


    }
}
