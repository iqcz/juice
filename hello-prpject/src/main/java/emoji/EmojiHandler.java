package emoji;

import com.vdurmont.emoji.EmojiParser;

public class EmojiHandler {

    public static void main(String[] args) {

        /*
        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);
    */
        String str = "An 😀awesome 😃string with a few 😉emojis!";
        String result = EmojiParser.parseToAliases(str);
        System.out.println(result);
    }
}
