package commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author i324779
 */
public final class Strings {

    private Strings() {
        throw new AssertionError("String can not be instantiated");
    }

    /**
     * counts duplicate characters from a given string.
     *
     * @param str a given string
     * @return the map of each char to counts
     */
    public static Map<String, Long> countDuplicateCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }

        return str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    /**
     * get the first non-repeated character from a given string.
     *
     * @param str a given string
     * @return returns the first non-repeated character from a given string.
     */
    public static String firstNonRepeatedCharacter(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return String.valueOf(Character.MIN_VALUE);
        }

        Map<Integer, Long> chs = str.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));
    }

    /**
     * reverses words of a given string.
     *
     * @param str a given string.
     * @return the reverse words
     */
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return new StringBuilder(str).reverse().toString();
    }

    /**
     * checks if the given string contains only digits.
     *
     * @param str
     * @return
     */
    public static boolean containsOnlyDigits(String str) {

        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }

    public static long countOccurrencesOfCertainCharacter(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return -1;
        }

        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static long countOccurrencesOfCertainCharacter(String str, String ch) {

        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            return -1;
        }

        if (ch.codePointCount(0, ch.length()) > 1) {
            // there is more than 1 Unicode character in the given String
            return -1;
        }

        int codePoint = ch.codePointAt(0);

        return str.codePoints()
                .filter(c -> c == codePoint)
                .count();
    }

    public static String removeCharacter(String str, char ch) {

        if (str == null || str.isEmpty()) {
            return "";
        }

        return str.chars()
                .filter(c -> c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String removeCharacter(String str, String ch) {

        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            return "";
        }

        if (ch.codePointCount(0, ch.length()) != 1) {
            // there is more than 1 Unicode character in the given String
            return "";
        }

        int codePoint = ch.codePointAt(0);

        return str.codePoints()
                .filter(c -> c != codePoint)
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.joining());
    }

    public static String removeWhitespaces(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return str.replaceAll("\\s", "");
    }

    public static String joinByDelimiter(char delimiter, String... args) {
        if (args == null || args.length == 0) {
            return "";
        }

        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    /**
     * removes the duplicate characters from the given string.
     *
     * @param str
     * @return
     */
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}
