package crazy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemInfo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String, String> env = System.getenv();
		for(String name : env.keySet()) {
			System.out.println(name + ": " + env.get(name));
		}
		
		System.out.println(System.getenv("JAVA_HOME"));
		Properties props = System.getProperties();
		props.store(new FileOutputStream("props.txt"), "System Properties");
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getenv("user.dir"));
		
		
		
		System.out.println(2<<4);
	}

}
