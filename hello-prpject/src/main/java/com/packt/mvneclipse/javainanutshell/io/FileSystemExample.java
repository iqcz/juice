package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * jar 文件可以理解为是一种文件系统，跟 zip 的操作方式相同。 
 * 往一个文件中写入内容，并添加到 jar 文件里。
 * 通过FileSystem 就可以往某一个文件系统里写入内容，
 * 把 FileSystem 的对象当做一个黑盒。
 * @author Yanxue Li
 *
 */
public class FileSystemExample {

    public static void main(String[] args) {
	Path tmpJar = Paths.get("guava-14.0.1-sources.jar");

	try(FileSystem workingFS = FileSystems.newFileSystem(tmpJar, null)) {
	    Path pathForFile = workingFS.getPath("world.txt");
	    List<String> ls = new ArrayList<>();
	    ls.add("Hello, World!");

	    Files.write(pathForFile, ls, Charset.defaultCharset(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }
}
