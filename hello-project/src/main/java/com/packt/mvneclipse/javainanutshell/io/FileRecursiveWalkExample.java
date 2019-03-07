package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * 递归遍历指定目录下所以的java文件
 * @author i324779
 *
 */
public class FileRecursiveWalkExample {

    public static void main(String[] args) {
	final Pattern isJava = Pattern.compile(".*\\.java$");
	final Path homeDir = Paths.get("/Users/i324779/juice/gof");
	try {
	    Files.find(homeDir, 255, // 遍历深度
		    (p, attrs) -> isJava.matcher(p.toString()).find()).forEach(q -> {
		System.out.println(q.normalize());
	    });
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
