package com.packt.mvneclipse.javainanutshell.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * use Files class to accomplish to copy file in nio package since java 7
 * 
 * @author Yanxue Li
 * @since 1.7
 *
 */
public class FilesExample {

    public static void main(String[] args) {
	// input.txt与 src 在同一级目录下，并且此文件事先已经存在
	File inputFile = new File("input.txt");
	try(InputStream in = new FileInputStream(inputFile)) {
	    Path outputPath = Paths.get("output.txt");
	    //	    if(Files.exists(outputPath)) {
	    //		Files.delete(outputPath);
	    //	    }
	    Files.deleteIfExists(outputPath); // 跟上面的 if 作用是一样的。
	    // 如果在 copy 之前，文件存在，再次执行，会提示 output.txt 已经存在，抛出异常。
	    Files.copy(in, Paths.get("output.txt"));
	} catch(FileNotFoundException e) {
	    e.printStackTrace();
	} catch(IOException e) {
	    e.printStackTrace();
	}

	Path path = Paths.get(System.getProperty("user.home") + File.separator + "he.txt");
	Path path2 = null;
	try {
	    path2 = Paths.get(new URI("file:///Users/Yanxue/he.txt"));
	} catch(URISyntaxException e) {
	    e.printStackTrace();
	}
	System.out.println(path2.equals(path)); // true;

	File f = path.toFile();
	System.out.println(f.isDirectory()); // false

	Path path3 = f.toPath();
	System.out.println(path3.equals(path)); // true

    }
}
