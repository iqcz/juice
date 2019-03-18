package algorithm.string;

import java.util.StringTokenizer;

/**
 * 给出一个反转给定句子中单词的算法。
 * 假设使用『 』空格作为分隔符。
 * @author i324779
 */
public class ReverseSentence {

    private static void reverseSentence(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        String reversedSentence = "";
        while (tokenizer.hasMoreElements()) {
            reversedSentence = String.format("%s %s", tokenizer.nextToken(), reversedSentence);
        }
        System.out.printf("Reversed string by word is: %s.", reversedSentence);
    }

    public static void main(String[] args) {
        String sentence = "Just do it";
        reverseSentence(sentence);
    }
}
