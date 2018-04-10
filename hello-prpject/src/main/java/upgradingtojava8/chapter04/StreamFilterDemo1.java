package upgradingtojava8.chapter04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterDemo1 {
    public static void main(String[] args) {
	Predicate<String> notCommentOrEmptyLine = 
		(line) -> line.trim().length() > 0 && !line.trim().startsWith("#");
	
	
	try (FileReader fr = new FileReader("example.txt"); 
		BufferedReader br = new BufferedReader(fr)) {
	    Stream<String> lines = br.lines();
	    lines.filter(notCommentOrEmptyLine)
	    .forEach(System.out::println);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}