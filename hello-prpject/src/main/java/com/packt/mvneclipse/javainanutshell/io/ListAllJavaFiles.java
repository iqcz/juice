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
 * 
 * @author TurtusLi
 *
 */
public class ListAllJavaFiles {

    public static void main(String[] args) {
	try (DirectoryStream<Path> stream = Files
		.newDirectoryStream(Paths.get("C:\\Users\\TurtusLi\\Documents\\Download"), "*.pdf")) {
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
