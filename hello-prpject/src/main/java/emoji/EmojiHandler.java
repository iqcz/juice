package emoji;

import com.vdurmont.emoji.EmojiParser;

public class EmojiHandler {

    public static void main(String[] args) {

        String aliaes = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String rst = EmojiParser.parseToUnicode(aliaes);
        System.out.println(rst);

        String str = "An 😀awesome 😃string with a few 😉emojis!";
        String result = EmojiParser.parseToAliases(str);
        System.out.println(result);

        // todo other methods to use.
    }
}
