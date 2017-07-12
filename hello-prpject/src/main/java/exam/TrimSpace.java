package exam;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrimSpace {

    public static void main(String[] args) throws IOException {

	Path path = Paths.get("kindle.txt");
	
	List<String> content = Files.readAllLines(path);
	List<String> noSpaceConent =new ArrayList<>();
	
	for(int i = 0; i < content.size();i++) {
	    String oneLine = content.get(i);
	    if(oneLine.contains(" ")){
		String temp = oneLine.replaceAll(" ", "");
		noSpaceConent.add(temp + "\r\n");
	    }
	    
	}
	
	System.out.println(noSpaceConent);
	
	Path outputPath = Paths.get("NewKindle.txt");
	
	Files.write(outputPath, noSpaceConent, Charset.defaultCharset());
    }

}
