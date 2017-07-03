package com.phideon.quickreference;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamDemo {

    public static void main(String[] args) {

	File file = new File("C:\\1.txt");
	try (InputStream in = new FileInputStream(file); 
		BufferedInputStream bis = new BufferedInputStream(in);) {
	    System.out.println("File size: " + file.length() + " Bytes.");

	    bis.read();
	    
	    System.out.println("Rest can be available: " + bis.available() + " Bytes.");
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
