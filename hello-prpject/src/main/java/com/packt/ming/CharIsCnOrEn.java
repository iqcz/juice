package com.packt.ming;

/**
 * 判断一个字符是汉字还是英文字符。
 * @author i324779
 */
public class CharIsCnOrEn {

    public static void main(String[] args) {
        System.out.println(isChineseOrEnglish('博'));
    }

    public static String isChineseOrEnglish(char c) {
        if (c >= 0 && c <= 9) {
            return "是数字字符";
        } else if (c >= 'a' && c <= 'z') {
            return "是小写字符";
        } else if (c >= 'A' && c <= 'Z') {
            return "是大写字符";
        } else if (Character.isLetter(c)) {
            return "是汉字字符";
        } else {
            return "是特殊字符";
        }
    }
}
