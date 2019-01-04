package crazy;

import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

import com.google.common.base.Joiner;

/**
 * a + aa + aaa + a...a 之和
 * @author i324779
 */
public class SumNumbers {

    private static final int BASE_NUMBER = 10;

    public static void main(String[] args) {
        new SumNumbers().sumNumbers(3, 4);
    }

    private int[] getNumbers(int num, int count) {
        int[] numbers = new int[count];
        int tmp = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                tmp += num * Math.pow(BASE_NUMBER, j);
            }
            numbers[i] = tmp;
            tmp = 0;
        }
        return numbers;
    }

    private int callResult(int[] numbers) {
        return IntStream.of(numbers).parallel().sum();
    }

    private String getString(int[] numbers) {
        return Joiner.on("+").join(IntStream.of(numbers).sorted().boxed().collect(toList()));
    }

    private void sumNumbers(int num, int count) {
        int[] numbers = getNumbers(num, count);
        System.out.println(getString(numbers) + " = " + callResult(numbers));
    }
}
