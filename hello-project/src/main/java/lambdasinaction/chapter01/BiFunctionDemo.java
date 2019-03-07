package lambdasinaction.chapter01;

import java.util.function.BiFunction;

/**
 * BiFunction takes two arguments and returns a result.
 * 
 * It uses BiFunction to create a function that calculates an area given a width and a length. 
 * @author i324779
 *
 */
public class BiFunctionDemo {

    public static void main(String[] args) {
        BiFunction<Float, Float, Float> area = (width, length) -> width * length;

        float width = 7.0F;
        float length = 10.0F;
        float result = area.apply(width, length);
        System.out.println(result);
    }
}