package upgradingtojava8.chapter04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFilterDemo2 {
    public static void main(String[] args) {
	// find all java files in the parent directory and
	// all its sub-directories
	Path parent = Paths.get("..");
	
	// /Users/i324779/juice/hello-prpject/..
	System.out.println(parent.toAbsolutePath());
	
	// notice: walk method
	try (Stream<Path> list = Files.walk(parent)) {
	    list.filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }
}