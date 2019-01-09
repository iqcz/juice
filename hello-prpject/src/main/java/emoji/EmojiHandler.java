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

        String specialEmoji = "AAA\ud83e\udd65ZZZ😉";

        String removedEmoji = EmojiParser.removeAllEmojis(specialEmoji);
        System.out.println(removedEmoji);

        // 框架处理不了的表情，转换为Unicode在字符串替换
        specialEmoji.replace("\ud83e\udd65", "")  // 替换emoji中椰子coconut表情
                .replace("\ud83e\udda2", ""); // 替换emoji中天鹅swan表情

    }
}
