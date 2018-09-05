package upgradingtojava8.chapter04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Use stream to list the files in the current file path.
 * @author i324779
 *
 */
public class ObtainStreamDemo {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (Stream<Path> list = Files.list(path)) {
            // Consumer functional function as parameter,
            // which has one parameter, and returns no result(void).
            list.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}