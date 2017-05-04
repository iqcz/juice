package crazy;

import java.io.File;

public class FileFilter {

	public static void main(String[] args) {
		File file = new File(".");
		String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
		
		for(String fileName : nameList) {
			System.out.println(fileName);
		}
	}

}
