package com.packt.mvneclipse.javainanutshell.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 在当前单一目录下，列出所有的pdf文件，并批量修改文件的名字。 
 * 以前的文件名格式为：[书名]作者名[某网站].pdf
 * 现在改为：书名.pdf
 * 此代码需要考虑的问题很多：
 * 1. 如果有多个扩展名，也就是有多个"." 的情况
 * 2. 如果改完名字以后，有重名的情况会怎么样
 * 3. 目前其实还是只是支持单一扩展名，例如要么全是 pdf，要么全是 txt，有待完善。
 * 
 * @author TurtusLi
 *
 */
public class ListAllJavaFiles {

    public static void main(String[] args) {
	try (DirectoryStream<Path> stream = Files
		.newDirectoryStream(Paths.get("/Users/i324779/Documents/Delicious/test"), "*.*")) {
	    for (Path p : stream) {
		File file = p.toFile();
		String oldName = file.getName();
		String newName = "";
		
		if (oldName.contains("[") && oldName.contains("]")) {
		    newName = oldName.substring(oldName.indexOf('[') + 1, oldName.indexOf(']')) + ".pdf";
		} else if (oldName.contains("[") && !oldName.contains("]")) {
		    newName = oldName.substring(oldName.indexOf('[') + 1) + ".pdf";
		}
		file.renameTo(new File(p.getParent().toString() + File.separator + newName));
	    }

	} catch (IOException e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}
    }
}
