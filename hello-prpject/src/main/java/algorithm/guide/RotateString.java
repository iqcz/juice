package algorithm.guide;

import com.google.common.base.Strings;

/**
 * @author i324779
 */
public class RotateString {

    public static void main(String[] args) {
        String str = "HelloWorld.";
        System.out.println(rotate(str));
    }

    public static String rotate(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return "";
        }

        StringBuilder builer = new StringBuilder();
        String[] spitedString = str.split(" ");
        for (int i = spitedString.length - 1; i >= 0; i--) {
            builer.append(spitedString[i]).append(" ");
        }
        return builer.toString();
    }
}
