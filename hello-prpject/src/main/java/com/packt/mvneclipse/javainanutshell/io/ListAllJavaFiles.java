package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 在当前单一目录下，列出所有的java文件，并打印每个文件大小。
 * @author TurtusLi
 *
 */
public class ListAllJavaFiles {

    public static void main(String[] args) {
	try(DirectoryStream<Path> stream = Files.newDirectoryStream(
		Paths.get("C:\\git\\juice\\hello-prpject\\src\\main\\java\\com\\packt\\mvneclipse\\javainanutshell\\io"), "*.java")) {
	    for(Path p :stream) {
		System.out.println(p.getFileName() + "' size: " + Files.size(p) + " bytes");
	    }
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
