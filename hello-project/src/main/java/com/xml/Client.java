package com.xml;

/**
 * @author i324779
 */
public class Client {
    public static void main(String[] args) {
        Sharp sharp = (Sharp) XmlUtil.getBean();

        sharp.setName("Sharp");

        System.out.println(sharp.getName());
    }
}
