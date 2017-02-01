package com.packt.mvneclipse.javainanutshell.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 在指定文件中查找字母‘a’的个数
 * @author i324779
 *
 */
public class FileExample {

	public static void main(String[] args) {
		File homeDir = new File(System.getProperty("user.home"));
		File conf = new File(homeDir, "app.conf");
		try (FileInputStream input = new FileInputStream(conf)) {
			byte[] buf = new byte[4096];
			int len, count = 0;
			while ((len = input.read(buf)) > 0) {
				for (int i = 0; i < len; i++) {
					if (buf[i] == 97) {
						count++;	
					}
				}
			}
			System.out.println("'a's seen: " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
