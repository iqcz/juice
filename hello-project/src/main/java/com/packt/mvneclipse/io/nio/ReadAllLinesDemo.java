package com.packt.mvneclipse.io.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * 使用Files类将文件所有内容放入到list之中。
 * @author TurtusLi
 *
 */
public class ReadAllLinesDemo {

	public static void main(String [] args) throws IOException {
		File file = new File("C:" + File.separator + "camera.log");
		List<String> lines = Files.readAllLines(file.toPath());
		
		for(String line : lines) {
			System.out.println(line);
		}
	}
}
