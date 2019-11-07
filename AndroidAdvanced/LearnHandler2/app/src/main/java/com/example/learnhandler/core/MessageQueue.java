package com.example.learnhandler.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Date：2019/11/7
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc:
 */
public class MessageQueue {

    //通过阻塞队列模拟 AOPS 中的 MessageQueue 的链表
    BlockingQueue<Message> mBlockingQueue = new ArrayBlockingQueue<Message>(50);

    //把消息 Message 进行压队
    public void enqueueMessage(Message msg) {
        try {
            mBlockingQueue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //读取 MessageQueue 的 Message
    public Message next() {
        try {
            return mBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
