package com.packt.mvneclipse.javainanutshell.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMatchExample {

    public static void main(String[] args) {

	Pattern SHELL_META_START = Pattern.compile("^#(\\w+)\\s*(\\w+)?");

	try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
	    String line;

	    READ: while((line = console.readLine()) != null) {
		// check for special commands("metas")
		Matcher m = SHELL_META_START.matcher(line);
		if(m.find()) {
		    String metaName = m.group(1);
		    String arg = m.group(2);

		    System.out.printf("%s, %s\n", metaName, arg);
		    // doMeta(metaName, arg);
		    continue READ;
		}
		System.out.println(line);
	    }
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }

}
