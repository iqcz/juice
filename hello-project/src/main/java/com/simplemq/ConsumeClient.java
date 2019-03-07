package com.simplemq;

/**
 * Created by niwei on 2018/2/13.
 */
public class ConsumeClient {

    public static void main(String[] args) throws Exception {
        String message = MqClient.consume();

        System.out.println("获取的消息为：" + message);
    }
}
