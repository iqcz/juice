package com.packt.mvneclipse.javainanutshell;

import java.io.File;

public class ShowJavaFile {

	public static void main(String[] args) {

		File dir = new File("src/main/java/com/packt/mvneclipse/javainanutshell");
		
		String[] fileList = dir.list((f, s) -> s.endsWith(".java"));
		
		for(int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
		}
	}

}
