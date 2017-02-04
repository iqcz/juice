package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
/**
 * 监控制定目录下的任何变化，如有变化就会打印对应的信息。
 * @author TurtusLi
 *
 */
public abstract class WatchServiceExample {

    public static void main(String[] args) {
	    boolean shutdown = false;
	    
	try {
	    WatchService watcher = FileSystems.getDefault().newWatchService();

	    Path dir = FileSystems.getDefault().getPath("C:/Users/TurtusLi/");
	    WatchKey key = dir.register(watcher,
	                          StandardWatchEventKinds.ENTRY_CREATE,
	                          StandardWatchEventKinds.ENTRY_MODIFY,
	                          StandardWatchEventKinds.ENTRY_DELETE);


	    while(!shutdown) {
	      key = watcher.take();
	      
	      for (WatchEvent<?> event: key.pollEvents()) {
	        Object o = event.context();
	        if (o instanceof Path) {
	          System.out.println("Path altered: "+ o);
	        }
	      }
	      
	      key.reset();
	    }
	  } catch(IOException | InterruptedException ioe) {
	      ioe.printStackTrace();
	  }
    }
}
