package com.simplemq;

/**
 * @author i324779
 */
public class ProduceClient {

    public static void main(String[] args) throws Exception {
        MqClient.produce("Hello World");
    }

}
