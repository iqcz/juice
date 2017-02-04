package com.packt.mvneclipse.javainanutshell.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 非阻塞IO的第二种方式 callback-based style
 * @author TurtusLi
 *
 */
public class CallbackBasedAsyncIO {

	public static void main(String[] args) {
		byte[] data = { 2, 3, 5, 7, 11, 13, 17, 19, 23 };
		ByteBuffer buffer = ByteBuffer.wrap(data);

		CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
			@Override
			public void completed(Integer result, Object attachment) { // success
				System.out.println("Bytes written: " + result);
			}

			@Override
			public void failed(Throwable exc, Object attachment) { // failed
				System.out.println("Asynch write failed: " + exc.getMessage());
			}
		};

		try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("primes.txt"),
				StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

			channel.write(buffer, 0, null, handler);
			
			Thread.sleep(10000); // Needed so we don't exit too quickly
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
