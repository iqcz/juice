package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

/**
 * 从给定的网站中读取里面的内容。
 * @author TurtusLi
 *
 */
public class HTTPExample {

    public static void main(String[] args) {
	URL url = null;
	try {
	    url = new URL("http://www.cnblogs.com/IcanFixIt/p/6364085.html");
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	}
	try (InputStream in = url.openStream()) {
	  Files.copy(in, Paths.get("output.html"), StandardCopyOption.REPLACE_EXISTING);
	} catch(IOException ex) {
	  ex.printStackTrace();
	}
	
	// or more low-level control, including metadata about the request and response,
	// we can use URLConnection to give us more control
	try {
	    URLConnection conn = url.openConnection();

	    String type = conn.getContentType();
	    String encoding = conn.getContentEncoding();
	    Date lastModified = new Date(conn.getLastModified());
	    int len = conn.getContentLength();
	    InputStream in = conn.getInputStream();
	    
	    System.out.println(type + ", " + encoding + ", " + lastModified + ", " + len);
	  } catch (IOException e) {
	  }
    }
}
