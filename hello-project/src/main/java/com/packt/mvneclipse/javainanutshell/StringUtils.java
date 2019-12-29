package com.packt.mvneclipse.javainanutshell;

/**
 * Usage: 获取字符串的实际长度
 *
 * @author Administrator
 */
public class StringUtils {

    /**
     * UTF-8 编码中文汉字的实际长度
     */
    public static final int UTF8_CN_CHAR_LENGTH = 3;

    /**
     * 要计算实际长度的字符串
     */
    private String str;

    /**
     * 字符串的长度
     */
    private int strLength;

    /**
     * 字符串  set 方法
     *
     * @return 字符串
     */
    public String getStr() {
        return str;
    }

    /**
     * 设置字符串
     *
     * @param str
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * 获取字符串的实际长度
     *
     * @return 字符串长度
     */
    public int getStrLength() {
        // 将字符串转换为字符数组
        char[] c = this.str.toCharArray();
        int factualLength = 0;
        for (int i = 0; i < c.length; i++) {
            // 获得字节数组的长度。
            factualLength = String.valueOf(c[i]).getBytes().length;
            // 当程序编码为UTF-8时，汉字的实际长度为3
            if (UTF8_CN_CHAR_LENGTH == factualLength) {
                factualLength = 2;
            }
            strLength += factualLength;
        }
        return strLength;
    }

    /**
     * 设置字符串长度。
     * 此功能暂未使用。
     *
     * @param strLength
     */
    public void setStrLength(int strLength) {
        this.strLength = strLength;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        StringUtils utils = new StringUtils();
        utils.str = "Hello.汉字";

        System.out.println(utils.getStrLength());
    }

}
