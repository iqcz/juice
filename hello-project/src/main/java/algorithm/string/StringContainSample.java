package algorithm.string;

/**
 * 《轻松学算法》P297
 * str2是否为str1的真子集，假设所有字符均为大写。
 * 
 * @author i324779
 */
public class StringContainSample {

    public static boolean contains(String str1, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            char bCharacter = str2.charAt(i);
            int count = 0;
            for (int j = 0; j < str1.length(); j++) {
                char aCharacter = str1.charAt(j);
                if (bCharacter != aCharacter) {
                    count++;
                }
            }

            if (count == str1.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(contains("abcdefg", "afgw"));
    }
}
