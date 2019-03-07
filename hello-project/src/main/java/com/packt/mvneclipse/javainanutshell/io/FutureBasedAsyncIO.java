package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 非阻塞IO的第一种方式 future-based style
 * @author TurtusLi
 *
 */
public class FutureBasedAsyncIO {

	public static void main(String[] args) {
		try(AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("input.txt"))) {
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 100);
			Future<Integer> result = channel.read(buffer, 0);
			
			while(!result.isDone()) {
				// do some other useful work
				System.out.println("reading file, I can do other work.");
			}
			 System.out.println("Bytes read: " + result.get());
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------End-------");
	}

}
