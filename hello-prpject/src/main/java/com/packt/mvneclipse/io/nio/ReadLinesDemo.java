package com.packt.mvneclipse.io.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * java 8 中的新方法，可以读取多行
 * BufferedReader.lines 方法
 * 注意file是否存在
 * 字符编码等问题
 * @author TurtusLi
 *
 */
public class ReadLinesDemo {	

	public static void main(String[] args) throws IOException {

		File file = new File("C:" + File.separator + "1.txt");

		BufferedReader in = new BufferedReader(new FileReader(file));

		Stream<String> lines = in.lines();

		lines.forEach((line) -> System.out.println(line));
		in.close();
	}
}
