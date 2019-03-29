package com.howtoprogram;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 剔除文本中的html标签
 * @author i324779
 *
 */
public class HtmlTagRemove {

    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        return htmlStr.trim(); // 返回文本字符串
    }

    public static void main(String[] args) {
        String txt = "&&AOP**<div style=\"text-align: center\" class=\"edui-insertvideo-aid\" data-aid=\"123123\"><a href=\"http://www.acfun.cn/v/ac123123_1\" style=\"display: inline-block;position: relative;min-height: 50px;min-width: 50px;\" target=\"_blank\"><div class=\"video-play-btn\"></div><img src=\"http://cdn.aixifan.com/dotnet/litimg/system/123123.jpg\" alt=\"\" data-videopic=\"comic-filt-img\"/></a></div><p>afasfsdfsfasfadsfasdfsdfads</p><p><img src=\"http://cdn.aixifan.com/dotnet/20130418/umeditor/dialogs/emotion/images/ac/02.gif\" class=\"img-emot-ac\"/></p>";
        System.out.println(delHTMLTag(txt));
    }
}